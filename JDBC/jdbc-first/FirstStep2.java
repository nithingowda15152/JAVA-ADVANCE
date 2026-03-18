package com.first;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
public class FirstStep2 {
	 public static void main(String[]args) {
		 try {
			DriverManager.registerDriver(new Driver());
			//registerDriver() is a method of the DriverManager class used to register a JDBC driver with the DriverManager so that Java can use that driver to connect to a database.
			//DriverManager keeps a list of all registered drivers-->MySQL Driver,Oracle Driver,PostgreSQL Driver
			//DriverManager checks this list and selects the correct driver.
			System.out.println("Registering Driver Class is Done...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
}