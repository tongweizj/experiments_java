/*
 * Name: Wei Tong"
 * Student ID: 301034450
 */
package com.example.wei_final;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Bill {
//    Account Number (String) (For Example, TH1234) (use TextField to input data)
//    Mobile usage minutes (integer) (For example, 230 minutes) (use TextField to input data)
//    Subscription Type (provide two options to select Personal or Commercial) (Use RadioButtons to select option)
    public SimpleStringProperty AccountNumber = new SimpleStringProperty();
    public SimpleIntegerProperty MobileUsageMins = new SimpleIntegerProperty();
    public SimpleStringProperty SubscriptionType = new SimpleStringProperty();
    public SimpleDoubleProperty EstimateAmount = new SimpleDoubleProperty();

    public Bill(String accountNumber, Integer mobileUsageMins, String subscriptionType) {
        this.AccountNumber.set(accountNumber);
        this.MobileUsageMins.set(mobileUsageMins);
        this.SubscriptionType.set(subscriptionType);
        if(subscriptionType == "Personal"){
            EstimateAmount.set(mobileUsageMins *0.25);
        } else if (subscriptionType =="Commercial") {
            EstimateAmount.set(mobileUsageMins * 0.30) ;
        }

    }

    public Bill(String accountNumber, Integer mobileUsageMins, String subscriptionType, Double estimateAmount) {
        this.AccountNumber.set(accountNumber);
        this.MobileUsageMins.set(mobileUsageMins);
        this.SubscriptionType.set(subscriptionType);
        this.EstimateAmount.set(estimateAmount);
    }

    public String getAccountNumber() {
        return AccountNumber.get();
    }

    public SimpleStringProperty accountNumberProperty() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.AccountNumber.set(accountNumber);
    }

    public int getMobileUsageMins() {
        return MobileUsageMins.get();
    }

    public SimpleIntegerProperty mobileUsageMinsProperty() {
        return MobileUsageMins;
    }

    public void setMobileUsageMins(int mobileUsageMins) {
        this.MobileUsageMins.set(mobileUsageMins);
    }

    public String getSubscriptionType() {
        return SubscriptionType.get();
    }

    public SimpleStringProperty subscriptionTypeProperty() {
        return SubscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.SubscriptionType.set(subscriptionType);
    }

    public double getEstimateAmount() {
        return EstimateAmount.get();
    }

    public SimpleDoubleProperty estimateAmountProperty() {
        return EstimateAmount;
    }

    public void setEstimateAmount(double estimateAmount) {
        this.EstimateAmount.set(estimateAmount);
    }
}
