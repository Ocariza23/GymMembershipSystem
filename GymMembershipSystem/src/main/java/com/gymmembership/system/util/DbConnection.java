package com.gymmembership.system.util;
import java.sql.*;

public class DbConnection {

    private final String URL = "jdbc:mysql://localhost:3306/dbgymbro";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    // String driver = "com.mysql.jdbc.Driver"; // old.. new asa baba
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public Connection con;
    public Statement state;
    public ResultSet result;
    public PreparedStatement prep;

    public void connect() throws SQLException {
        try {
                Class.forName(DRIVER); // call driver
                //open connection
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Connection Failed! " + e.getMessage());
        }

    }
               
    //MJ's setup
    String serverName = "localhost\\SQLEXPRESS";
    String dbName = "dbgymbro";
    String username = "mj";
    String password = "Password";

    public Connection dbConnect(){
        
        String urlConnection = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + dbName + ";encrypt=false;trustServerCertificate=true";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            return DriverManager.getConnection(urlConnection, username, password);

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
        return null;
    }
}
