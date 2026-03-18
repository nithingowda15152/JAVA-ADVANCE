package com.first;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class SecondStep {
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
		String user="root";
		String password="root";
		
		//Single try with single Exception
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("First Step is Done.....");
			
			//step 2
			Connection con=DriverManager.getConnection(url,user,password);
			System.out.println("Second Step is Done...... "+con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Single try with Multiple Exception
		/*
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("First Step is Done.....");
			
			//step 2
			Connection con=DriverManager.getConnection(url,user,password);
			System.out.println("Second Step is Done...... "+con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
		    e.printStackTrace();
		}*/
		
	}
}
