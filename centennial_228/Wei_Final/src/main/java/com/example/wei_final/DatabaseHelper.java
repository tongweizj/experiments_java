/*
 * Name: Wei Tong"
 * Student ID: 301034450
 */
package com.example.wei_final;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseHelper {
    //singleton pattern
    private static DatabaseHelper _dbHelper;
    private Connection dbConnection;
    private final String TABLE_NAME = "BILLS";
    private PreparedStatement insertStatement;
    public ObservableList<Bill> billList = FXCollections.observableArrayList();

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
        try{

            String driverType = "jdbc:oracle:thin";
            //use this host name when connecting from campus CcwSecure wifi
            String host = "@oracle1.centennialcollege.ca";
            //use this host when connecting from anywhere else
            //String host = "@199.212.26.208";
            int port = 1521;
            String sid = "SQLD";

            //jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD
            String hostString = driverType + ":" + host + ":" + port + ":" + sid;
            System.out.println("hostString : " + hostString);

            String username = "COMP228_F24_jig_58";
            String password = "tw273634";

            //register the driver
            Class.forName("oracle.jdbc.OracleDriver");

            //obtain the connection using hostString and credentials
            this.dbConnection =
                    DriverManager.getConnection(hostString, username, password);

            if(this.dbConnection != null){
                System.out.println("Database connection established successfully");

                this.createTable();

                //prepare insert statement
                String insertQuery = "INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?, ?)";
                System.out.println("insertQuery : " + insertQuery);
                this.insertStatement = this.dbConnection.prepareStatement(insertQuery);

            }else{
                System.out.println("Cannot get database connection.");
            }
        }catch (SQLException ex){
            System.out.println("Error while connecting to database : " + ex);
        }catch (Exception ex){
            System.out.println("Something went wrong : " + ex);
        }
    }

    private void createTable() {
        try{
            //get information about database such as table names within it
            DatabaseMetaData databaseMetaData =
                    this.dbConnection.getMetaData();

            //access table with given name within the database
            //used to check if table already exist
            ResultSet resultSet =
                    databaseMetaData.getTables(null,
                            null, TABLE_NAME , null);
            System.out.println("Good2.");
            if(resultSet.next()){
                System.out.println("Table already exist.");
                this.getAllRecords();
            }else{
                System.out.println("Good.");
                //no table with given name exist; create one
                String createTableQuery = "CREATE TABLE " + TABLE_NAME +
                        " (" +
                        "AccountNumber VARCHAR(50), " +
                        "MobileUsageMins NUMBER(5), " +
                        "SubscriptionType VARCHAR(10), " +
                        "EstimateAmount NUMBER(5, 2) " +
                        ")"
                        ;

                System.out.println("Query : " + createTableQuery);

                if (!this.dbConnection.isClosed()){
                    //create object of Statement class
                    Statement statement = this.dbConnection.createStatement();
                    //execute the statement with query
                    int n = statement.executeUpdate(createTableQuery);

                    if (n >= 0){
                        System.out.println("Table " + TABLE_NAME + " created successfully");
                    }else{
                        System.out.println("cannot create table " + TABLE_NAME);
                    }

                    if (!statement.isClosed()){
                        statement.close();
                    }

                }


            }

        }catch (SQLException ex){
            System.out.println("Error while creating table : " + ex);
        }catch (Exception ex){
            System.out.println("Something went wrong : " + ex);
        }
    }

    public boolean insertToDB(Bill billToInsert){

        try{

            if (!this.dbConnection.isClosed()){
                this.insertStatement.setString(1, billToInsert.getAccountNumber());
                this.insertStatement.setDouble(2, billToInsert.getMobileUsageMins());
                this.insertStatement.setString(3, billToInsert.getSubscriptionType());
                this.insertStatement.setDouble(4, billToInsert.getEstimateAmount());


                int n = this.insertStatement.executeUpdate();

                if (n > 0){
                    System.out.println("Record inserted successfully. StudentID : " + billToInsert.getAccountNumber());
                    this.getAllRecords();
                    return true;
                }else{
                    System.out.println("Record not inserted for StudentID : " + billToInsert.getAccountNumber());
                }

            }else{
                System.out.println("Cannot insert. Database is closed.");
            }

        }catch (SQLException ex){
            System.out.println("Error while inserting record : " + ex);
        }catch (Exception ex){
            System.out.println("Something went wrong : " + ex);
        }

        return false;
    }

    public void getAllRecords() {
        try{

            if(!this.dbConnection.isClosed()){
                Statement statement = this.dbConnection.createStatement();
                String selectQuery = "SELECT * FROM " + TABLE_NAME;
                ResultSet resultSet = statement.executeQuery(selectQuery);
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();

                if (columnCount > 0) {
                    //remove any existing data from gpalist
                    this.billList = FXCollections.observableArrayList();
                }

                Bill billFromDB;
                while (resultSet.next()){
                    System.out.println("resultSet : " + resultSet);
                    billFromDB = new Bill(
                            resultSet.getString(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4)
                    );

                    //add object to array
                    this.billList.add(billFromDB);
                }

                System.out.println("billList : " + billList);
            }

        }catch (SQLException ex){
            System.out.println("Error while retrieving data : " + ex);
        }catch (Exception ex){
            System.out.println("Something went wrong : " + ex);
        }
    }

    public void closeConnections() {
        try{

            if(!this.insertStatement.isClosed()){
                this.insertStatement.close();
            }

            if(!this.dbConnection.isClosed()){
                this.dbConnection.close();
            }

        }catch (SQLException ex){
            System.out.println("Error while closing connection : " + ex);
        }catch (Exception ex){
            System.out.println("Something went wrong : " + ex);
        }
    }
}
