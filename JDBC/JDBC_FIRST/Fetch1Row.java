package com.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Fetch1Row {
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
			String query="SELECT * FROM student WHERE stuid=101";
			//Step 4
			state.execute(query);
			//how to display the data
			ResultSet rs=state.getResultSet();
//			System.out.println(rs);
			if(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString("stuname");
				double marks=rs.getDouble(3);
				String email=rs.getString(4);
				System.out.println(id+" "+name+" "+marks+" "+email);
			}else {
				System.out.println("id is nort present");
			}
			//Step 5
			con.close();
			System.out.println("Data Fetched Succesfully..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
