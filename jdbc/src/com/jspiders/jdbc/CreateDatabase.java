package com.jspiders.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import com.mysql.cj.jdbc.Driver;

public class CreateDatabase {
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	 
	//load the driver
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 //Register the driver
	 Driver driver = new Driver();
	 
	 DriverManager.registerDriver(driver);
	 
	 //get connection 
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4996?user=root&password=root");

//create connection
Statement statement = connection.createStatement();

//execute the statement
statement.execute("CREATE DATABASE demo12");

//process the result
System.out.println("database created");

//close connection
statement.close();
connection.close();

//De-register the driver
DriverManager.deregisterDriver(driver);
	 
}
}



