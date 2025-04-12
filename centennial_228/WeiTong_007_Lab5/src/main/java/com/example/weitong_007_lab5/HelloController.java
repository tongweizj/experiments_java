package com.example.weitong_007_lab5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController  implements Initializable {
    public TextField tfStudentID;
    @FXML private  Label lblOutput;
    @FXML private  TextField tfTermOne;
    @FXML private  TextField tfTermTwo;
    @FXML private  TextField tfTermThree;
    @FXML private  Button btnSaveData;
    @FXML private  Button clearButton;

    //    Table View properties
    @FXML private  TableView<GPA> gpaTableView;
    @FXML private  TableColumn<GPA, String> colSID;
    @FXML private  TableColumn<GPA, Double> colTermOne;
    @FXML private  TableColumn<GPA, Double> colTermTwo;
    @FXML private  TableColumn<GPA, Double> colTermThree;
    @FXML private  TableColumn<GPA, Double>  colCGPA;

    DatabaseHelper dbHelper = DatabaseHelper.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //associate the table View columns to Book class properties
        this.colSID.setCellValueFactory(new PropertyValueFactory<GPA, String>("studentID"));
        this.colTermOne.setCellValueFactory(new PropertyValueFactory<GPA, Double>("termOne"));
        this.colTermTwo.setCellValueFactory(new PropertyValueFactory<GPA, Double>("termTwo"));
        this.colTermThree.setCellValueFactory(new PropertyValueFactory<GPA, Double>("termThree"));
        this.colCGPA.setCellValueFactory(new PropertyValueFactory<GPA, Double>("termCGPA"));
        this.lblOutput.setText("");
        //associate database helper gpalist to tableview
        this.gpaTableView.setItems(this.dbHelper.gpaList);
        //refresh the table view to show updated list of books
        this.gpaTableView.refresh();
    }

    public void btnSaveDataClick() {
        lblOutput.setText("GPA Information");

        String output = "";
        String SID = "";
        Double TermOne = 0.0;
        Double TermTwo = 0.0;
        Double TermThree = 0.0;
        Double CGPA = 0.0;


        //get the input from the TextField using getText()
        if (this.tfStudentID.getText().isEmpty()){
            output += "GPA Information\nStudent ID : Student ID cannot be empty";
        }else{
            SID = this.tfStudentID.getText();
        }

        if (this.tfTermOne.getText().isEmpty() ||
                Double.parseDouble(this.tfTermOne.getText()) <= 0 ||
        Double.parseDouble(this.tfTermOne.getText()) > 4){
            output += "GPA must be more than 0 and  less than 4";
        }else {
            TermOne = Double.parseDouble(this.tfTermOne.getText());
        }
        if (this.tfTermTwo.getText().isEmpty() ||
                Double.parseDouble(this.tfTermTwo.getText()) <= 0 ||
                Double.parseDouble(this.tfTermTwo.getText()) > 4){
            output += "GPA must be more than 0 and  less than 4";
        }else {
            TermTwo = Double.parseDouble(this.tfTermTwo.getText());
        }
        if (this.tfTermThree.getText().isEmpty() ||
                Double.parseDouble(this.tfTermThree.getText()) <= 0 ||
                Double.parseDouble(this.tfTermThree.getText()) > 4){
            output += "GPA must be more than 0 and  less than 4";
        }else {
            TermThree = Double.parseDouble(this.tfTermThree.getText());
        }

        lblOutput.setText(output);

        //check if the data is valid
        if (SID.isEmpty() || TermOne.isNaN() ||TermTwo.isNaN() || TermThree.isNaN()
                ){

            System.out.println("Data invalid. Can't insert record.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Insert - Error");
            alert.setContentText("Please enter all details");
            alert.show();

        }else{
            GPA gpaToInsert =
                    new GPA(SID, TermOne, TermTwo, TermThree);

            boolean success = this.dbHelper.insertToDB(gpaToInsert);

            if (success){
                //associate database helper booklist to tableview
                this.gpaTableView.setItems(this.dbHelper.gpaList);
                //refresh the table view to show updated list of books
                this.gpaTableView.refresh();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Insert - Success");
                alert.setContentText(gpaToInsert.getStudentID() + " saved to database");
                alert.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Insert - Error");
                alert.setContentText(gpaToInsert.getStudentID() + " not saved to database");
                alert.show();
            }
        }
    }
}