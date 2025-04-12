package com.example.bookstore;

public class DatabaseHelper {
    //singleton pattern
    private static DatabaseHelper _dbHelper;

    public static DatabaseHelper getInstance() {
        if (_dbHelper == null){
            _dbHelper = new DatabaseHelper();
        }

        return _dbHelper;
    }

    private DatabaseHelper(){
        this.connectToDB();
    }

    public void connectToDB() {

    }

    private void createTable() {

    }

    public boolean insertToDB(Book bookToInsert){
        return false;
    }

    public void getAllRecords() {

    }

    public void closeConnections() {

    }

}
