package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user = "root";
		String password = "root";

		try {
			// Step 1: Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Create Connection
			Connection con = DriverManager.getConnection(url, user, password);

			// Step 3: Create PreparedStatement
			String query = "INSERT INTO student VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			// Step 4: Take input from user
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter Student ID: ");
			int id = sc.nextInt();

			System.out.println("Enter Student NAME: ");
			String name = sc.next();

			System.out.println("Enter Student MARKS: ");
			double marks = sc.nextDouble();

			System.out.println("Enter Student EMAIL: ");
			String email = sc.next();

			// Step 5: Set values
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, marks);
			ps.setString(4, email);

			// Step 6: Execute Query
			ps.execute();

			// Step 7: Close Connection
			con.close();
			System.out.println("Data Inserted Successfully");

		} 
		catch (ClassNotFoundException e) {
			System.out.println("Driver Class Not Found");
			e.printStackTrace();
		} 
		catch (SQLException e) {
			System.out.println("Database Error Occurred");
			e.printStackTrace();
		}

	}
}