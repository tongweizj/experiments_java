package com.example.bookstore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseHelper {
    //singleton pattern
    private static DatabaseHelper _dbHelper;
    private Connection dbConnection;
    private final String TABLE_NAME = "BOOKS_07_TABLE";
    private PreparedStatement insertStatement;
    public ObservableList<Book> bookList = FXCollections.observableArrayList();

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
//            String host = "@oracle1.centennialcollege.ca";
            //use this host when connecting from anywhere else
            String host = "@199.212.26.208";
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
                String insertQuery = "INSERT INTO " + TABLE_NAME + " VALUES(?, ?, ?, ?, ?, ?, ?)";
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

            if(resultSet.next()){
                System.out.println("Table already exist.");
                this.getAllRecords();
            }else{
                //no table with given name exist; create one
                String createTableQuery = "CREATE TABLE " + TABLE_NAME +
                        " (" +
                        "Title VARCHAR(50), " +
                        "Author VARCHAR(50), " +
                        "Category VARCHAR(50), " +
                        "CoverType VARCHAR(50), " +
                        "Quantity NUMBER(5), " +
                        "Price NUMBER(5, 2), " +
                        "Total NUMBER(5, 2)" +
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

    public boolean insertToDB(Book bookToInsert){

        try{

            if (!this.dbConnection.isClosed()){
                this.insertStatement.setString(1, bookToInsert.getTitle());
                this.insertStatement.setString(2, bookToInsert.getAuthor());
                this.insertStatement.setString(3, bookToInsert.getCategory());
                this.insertStatement.setString(4, bookToInsert.getCoverType());
                this.insertStatement.setInt(5, bookToInsert.getQuantity());
                this.insertStatement.setDouble(6, bookToInsert.getPrice());
                this.insertStatement.setDouble(7, bookToInsert.getTotal());

                int n = this.insertStatement.executeUpdate();

                if (n > 0){
                    System.out.println("Record inserted successfully. Title : " + bookToInsert.getTitle());
                    this.getAllRecords();
                    return true;
                }else{
                    System.out.println("Record not inserted for book : " + bookToInsert.getTitle());
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
                    //remove any existing data from booklist
                    this.bookList = FXCollections.observableArrayList();
                }

                Book bookFromDB;
                while (resultSet.next()){
                    bookFromDB = new Book(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getInt(5),
                            resultSet.getDouble(6),
                            resultSet.getDouble(7)
                    );

                    //add object to array
                    this.bookList.add(bookFromDB);
                }

                System.out.println("bookList : " + bookList);
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
