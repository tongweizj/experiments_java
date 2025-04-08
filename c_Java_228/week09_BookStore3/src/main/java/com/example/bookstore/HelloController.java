package com.example.bookstore;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/*
use Initializable interface if you need to initialize some data or properties
to the UI controls when they are being created
 */
public class HelloController implements Initializable {
    /*
    associate control objects to its respective FXML tags using fx:id property
     */
    @FXML
    private TextField tfBookTitle;

    @FXML private TextField tfAuthor;
    @FXML private Label lblOutput;
    @FXML private RadioButton rdbFiction;
    @FXML private RadioButton rdbNonFiction;
    @FXML private RadioButton rdbBiography;
    @FXML private ToggleGroup groupCategory;
    @FXML private ComboBox cmbCoverType;
    @FXML private TextField tfQuantity;

    //    Table View properties
    @FXML private TableView<Book> bookTableView;
    @FXML private TableColumn<Book, String> colTitle;
    @FXML private TableColumn<Book, String> colAuthor;
    @FXML private TableColumn<Book, String> colCategory;
    @FXML private TableColumn<Book, String> colCoverType;
    @FXML private TableColumn<Book, Integer> colQuantity;
    @FXML private TableColumn<Book, Double> colPrice;
    @FXML private TableColumn<Book, Double> colTotal;

    DatabaseHelper dbHelper = DatabaseHelper.getInstance();

    /*
    associate the onSaveButtonClick function with its UI control (Button)
    on fxml file using onAction="#" property
     */
    @FXML protected void onSaveButtonClick(){
        lblOutput.setText("Book Information");

        String output = "Book Information";
        String title = "";
        String author = "";
        String category = "";
        String coverType = "";

        //get the input from the TextField using getText()
        if (this.tfBookTitle.getText().isEmpty()){
            output += "\nTitle : Title cannot be empty";
        }else{
            title = this.tfBookTitle.getText();
        }
        
        if (this.tfAuthor.getText().isEmpty()){
            output += "\nAuthor : Author cannot be empty";
        }else {
            author = this.tfAuthor.getText();
        }

        RadioButton selectedRadioButton =
                (RadioButton) this.groupCategory.getSelectedToggle();
        category = selectedRadioButton.getText();

        CoverType selectedCoverType = null;
        //get the CoverType selection from ComboBox
        if (this.cmbCoverType.getValue() != null
            && !this.cmbCoverType.getValue().toString().isEmpty()){

            selectedCoverType = (CoverType) this.cmbCoverType.getValue();
        }
        
        coverType = selectedCoverType.name();

        int quantity = 0;
        
        if (this.tfQuantity.getText().isEmpty() || 
                Integer.parseInt(this.tfQuantity.getText()) <= 0){
            output += "Quantity must be 1 or more";
            quantity = 1;
        }else {
            quantity = Integer.parseInt(this.tfQuantity.getText());
        }

        lblOutput.setText(output);

        //check if the data is valid
        if (title.isEmpty() || author.isEmpty() || category.isEmpty() ||
        selectedCoverType.name().isEmpty()){

            System.out.println("Data invalid. Can't insert record.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Insert - Error");
            alert.setContentText("Please enter all details");
            alert.show();

        }else{
            Book bookToInsert =
                    new Book(title, author, category, selectedCoverType.name(), quantity);

            boolean success = this.dbHelper.insertToDB(bookToInsert);

            if (success){
                //associate database helper booklist to tableview
                this.bookTableView.setItems(this.dbHelper.bookList);
                //refresh the table view to show updated list of books
                this.bookTableView.refresh();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Insert - Success");
                alert.setContentText(bookToInsert.getTitle() + " saved to database");
                alert.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Insert - Error");
                alert.setContentText(bookToInsert.getTitle() + " not saved to database");
                alert.show();
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //perform required initialization for UI controls or data or app

        //1. create an instance of the ToggleGroup
        this.groupCategory = new ToggleGroup();

        //2.associate all the RadioButtons for book category to ToggleGroup
        this.rdbFiction.setToggleGroup(this.groupCategory);
        this.rdbNonFiction.setToggleGroup(this.groupCategory);
        this.rdbBiography.setToggleGroup(this.groupCategory);

        //initialize the cover types to ComboBox
        /*
        ComboBox must receive possible values from Array using setItems()

        If using enum to assign the values, get all the values of enum using
        enumName.values()

        Then convert it into FXCollections.observableArrayList
         */

        this.cmbCoverType.setItems(
                FXCollections.observableArrayList(CoverType.values()));
        this.cmbCoverType.getSelectionModel().selectFirst();

        //set the first value selected by default
        this.cmbCoverType.getSelectionModel().selectFirst();

        //associate the table View columns to Book class properties
        this.colTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        this.colAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        this.colCategory.setCellValueFactory(new PropertyValueFactory<Book, String>("category"));
        this.colCoverType.setCellValueFactory(new PropertyValueFactory<Book, String>("coverType"));
        this.colPrice.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory<Book, Double>("total"));
        this.colQuantity.setCellValueFactory(new PropertyValueFactory<Book, Integer>("quantity"));

        //associate database helper booklist to tableview
        this.bookTableView.setItems(this.dbHelper.bookList);
        //refresh the table view to show updated list of books
        this.bookTableView.refresh();
    }

    public void onQuitClick(){
        //close database connection
        this.dbHelper.closeConnections();

        //close GUI window
        Platform.exit();
    }
}