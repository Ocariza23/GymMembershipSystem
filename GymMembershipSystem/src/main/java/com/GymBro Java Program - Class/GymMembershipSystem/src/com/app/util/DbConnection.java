package com.app.util;

import java.sql.*;

public abstract class DbConnection {

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
}
