package com.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		try {
			//STEP:1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//STEP:2
			Connection con=DriverManager.getConnection(url,user,password);
			//STEP:3
			Statement state=con.createStatement();
			//write query in string format
			String query="UPDATE student SET stuname='jerry' WHERE stuid=101";
			//Step 4
			state.executeUpdate(query);
			//Step 5
			con.close();
			System.out.println("Data Updated Succesfully..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
