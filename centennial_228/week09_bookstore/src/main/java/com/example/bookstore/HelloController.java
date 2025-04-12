package com.example.bookstore;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController {
    /*
     * associate control objects to its respective FXML tags using fx: id property
     * */
    @FXML
    private TextField tfBookTitle;
    @FXML
    private TextField tfBookAuthor;
    @FXML private Label lblBookTitle;
    @FXML private Label lblBookAuthor;
    @FXML private Label lblOutput;
    @FXML private RadioButton rdbA;
    @FXML private RadioButton rdbB;
    @FXML private RadioButton rdbC;
    @FXML private ComboBox cbmCoverType;
    @FXML private void onSaveButtonClick(){
        String output = "Book infor";
        if(this.tfBookTitle.getText().isEmpty()){
            output += "\n Title can not be empty";
        }else {
            output += "\nTitle:" + this.tfBookTitle.getText();
        }
        if(this.tfBookAuthor.getText().isEmpty()){
            output += "\n Author can not be empty";
        }else {
            output += "\nTitle:" + this.tfBookAuthor.getText();
        }

        lblOutput.setText(output);
    }

    public void initialize(){
        String[] cover_type = {"PAPEBACK", "HARDCOVER", "KINDLE_EDITION"};
        this.cbmCoverType.setItems(FXCollections.observableArrayList(cover_type));
        this.cbmCoverType.getSelectionModel().selectFirst();

        lblOutput.setText("Hi!");
    }
}