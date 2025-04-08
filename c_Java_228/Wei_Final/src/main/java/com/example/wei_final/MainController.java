/*
 * Name: Wei Tong"
 * Student ID: 301034450
 */
package com.example.wei_final;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController  implements Initializable{
    @FXML private  Label lblOutput;
    @FXML private TextField tfMobileAccountNumber;
    @FXML private TextField tfMobileUsageMins;
    @FXML private Button btnSaveData;
    //    Table View properties
    @FXML private TableView<Bill> billTableView;
    @FXML private TableColumn<Bill, String> colAccountNumber;
    @FXML private  TableColumn<Bill, Integer> colMobileUsageMins;
    @FXML private  TableColumn<Bill, String> colSubscriptionType;
    @FXML private  TableColumn<Bill, Double> colEstimateAmount;


    DatabaseHelper dbHelper = DatabaseHelper.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //associate the table View columns to Book class properties
        this.colAccountNumber.setCellValueFactory(new PropertyValueFactory<Bill, String>("AccountNumber"));
        this.colMobileUsageMins.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("MobileUsageMins"));
        this.colSubscriptionType.setCellValueFactory(new PropertyValueFactory<Bill, String>("SubscriptionType"));
        this.colEstimateAmount.setCellValueFactory(new PropertyValueFactory<Bill, Double>("EstimateAmount"));

        this.lblOutput.setText("");
        //associate database helper gpalist to tableview
        this.billTableView.setItems(this.dbHelper.billList);
        //refresh the table view to show updated list of books
        this.billTableView.refresh();
    }
    public void btnSaveDataClick(ActionEvent actionEvent) {
        lblOutput.setText("Mobile Information");

        String output = "";
        String AccountNumber = "";
        Integer MobileUsageMins = 0;
        String SubscriptionType = "Personal";
        Double EstimateAmount = 0.0;


        //get the input from the TextField using getText()
        if (this.tfMobileAccountNumber.getText().isEmpty()){
            output += "Mobile Information\nMobile Account Number : Mobile Account Number cannot be empty";
        }else{
            AccountNumber = this.tfMobileAccountNumber.getText();
        }

        if (this.tfMobileUsageMins.getText().isEmpty()){
            output += "Mobile Information\nMobile Usage Mins : Mobile Usage Mins cannot be empty";
        }else{
            MobileUsageMins = Integer.valueOf(this.tfMobileUsageMins.getText());
        }

        Bill billToInsert =
                new Bill(AccountNumber, MobileUsageMins, SubscriptionType);

        boolean success = this.dbHelper.insertToDB(billToInsert);

        if (success){
            //associate database helper booklist to tableview
            this.billTableView.setItems(this.dbHelper.billList);
            //refresh the table view to show updated list of books
            this.billTableView.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Insert - Success");
            alert.setContentText(billToInsert.getAccountNumber() + " saved to database");
            alert.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Insert - Error");
            alert.setContentText(billToInsert.getAccountNumber() + " not saved to database");
            alert.show();
        }
    }
}
