package com.example.bookstore;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    public SimpleStringProperty title = new SimpleStringProperty();
    public SimpleStringProperty author = new SimpleStringProperty();
    public SimpleStringProperty category = new SimpleStringProperty();
    public SimpleStringProperty coverType = new SimpleStringProperty();
    public SimpleIntegerProperty quantity = new SimpleIntegerProperty();
    public SimpleDoubleProperty price = new SimpleDoubleProperty();
    public SimpleDoubleProperty total = new SimpleDoubleProperty();

    //used for inserting book
    public Book(String title, String author, String category, String coverType, int quantity) {
        this.title.set(title);
        this.author.set(author);
        this.category.set(category);
        this.coverType.set(coverType);
        this.quantity.set(quantity);

        switch (coverType){
            case "PAPERBACK" :
                price.set(10.00);
                break;
            case "HARDCOVER":
                price.set(15.0);
                break;
            case "KINDLE_EDITION":
                price.set(25.0);
                break;
            default:
                price.set(30.0);
                break;
        }

        this.total.set(quantity * price.get());
    }


    //used for retrieving book
    public Book(String title, String author, String category, String coverType, int quantity, double price, double total) {
        this.title.set(title);
        this.author.set(author);
        this.category.set(category);
        this.coverType.set(coverType);
        this.quantity.set(quantity);
        this.price.set(price);
        this.total.set(total);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public String getCoverType() {
        return coverType.get();
    }

    public SimpleStringProperty coverTypeProperty() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType.set(coverType);
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

}

