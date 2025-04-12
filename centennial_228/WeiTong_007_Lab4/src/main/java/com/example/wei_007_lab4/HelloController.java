package com.example.wei_007_lab4;


import javafx.beans.value.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class HelloController {
    /*
     * associate control objects to its respective FXML tags using fx: id property
     * */

    @FXML
    private Label lblReceipt;
    @FXML
    private Label lblItemsNumber;

    @FXML
    private ComboBox cbmGroceryItem;
    @FXML
    private ComboBox cbmGroceryQuantity;
    @FXML
    private TextField tfCustomerName;
    @FXML
    private TextField tfCustomerAddress;
    @FXML
    private Label lblOutput;
    @FXML
    private RadioButton rdbA;
    @FXML
    private RadioButton rdbB;
    private ToggleGroup toggleGroup;
    private String toggleGroupSelected;
    private Map<String, Integer> shopCartProducts = new HashMap<>();
    ;



    @FXML
    public void initialize() {
        /*
         * comboBox
         * */
        Product product = new Product();
        String[] product_list = product.getProductNames();
        this.cbmGroceryItem.setItems(FXCollections.observableArrayList(product_list));
        this.cbmGroceryItem.getSelectionModel().selectFirst();

        String[] input_number = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9"};
        this.cbmGroceryQuantity.setItems(FXCollections.observableArrayList(input_number));
        this.cbmGroceryQuantity.getSelectionModel().selectFirst();

        toggleGroup = new ToggleGroup();
        toggleGroupSelected = "";
        rdbA.setToggleGroup(toggleGroup);
        rdbB.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n) {
                RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();
                if (rb != null) {
                    toggleGroupSelected = rb.getText();
                }
            }
        });
        lblReceipt.setText("");
    }

    public void onSaveItemButtonClick(ActionEvent actionEvent) {
        if(this.cbmGroceryQuantity.getValue().toString()=="0"){
            shopCartProducts.remove(this.cbmGroceryItem.getValue().toString());
        }else {

            shopCartProducts.put(this.cbmGroceryItem.getValue().toString(), Integer.parseInt(this.cbmGroceryQuantity.getValue().toString()));
//        lblOutput.setText(Product.getProductReceipt(shopCartProducts));

        }
        lblItemsNumber.setText(shopCartProducts.size() + " items");

    }

    public void onPlaceOrderClick(ActionEvent actionEvent) {
        String name = this.tfCustomerName.getText().toString();
        String address = this.tfCustomerAddress.getText().toString();
        String receiptTitle = shopCartProducts.size() == 0||name.isEmpty() || address.isEmpty()? "":"Receipt" ;
        lblReceipt.setText(receiptTitle);
        lblOutput.setText(Product.getProductReceipt(name, address, toggleGroupSelected, shopCartProducts));
    }

}