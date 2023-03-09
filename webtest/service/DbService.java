package webtest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import webtest.model.User;

public class DbService {
	// These help to login into MySQL
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/userdb";
	private String username = "root";
	private String password = "root";
	private Connection connection;

	// This is used to load the driver for MySQL
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// This is used to connect to MySQL
	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// This method adds the user into MySQL
	// (NOT FINISHED) We need a function that finds duplicates and sends user an error
	public void addUser(User user) {
		// Usually put the loadDriver and connection into each method in the future
		loadDriver(dbDriver);
		Connection connection = getConnection();
		
		// Writes the mySQL statement for mySQL
		String sql = "insert into userdb.user values(?,?,?)";
		// We need a try catch to see if there are any errors
		try {
			// Based on the user's input in Register.java, it gathers the data
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			// And then enters the data into MySQL
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// This method figures out if there is the same email and password inputted into the form based on the mySQL database
	public boolean loginUser(String email, String password) {
		loadDriver(dbDriver);
		Connection connection = getConnection();
		// We place the status as false to go through each data in the mySQL, until it can find a match
		boolean status = false;
		try {
			// Writes the mySQL statement for mySQL
			PreparedStatement pstmt = connection
					.prepareStatement("select * from userdb.user where email = ? and password = ?");
			// Based on the user's input in Login.java, it gathers the data
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			// Created a variable that would execute the mySQL statement
			ResultSet rs = pstmt.executeQuery();
			// Based on the data, it would look through everything in mySQL
			status = rs.next();
		} catch (Exception e) {
		}
		return status;
	}
}
