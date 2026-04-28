package com.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbc-second-db?createDatabaseIfNotExist=true";
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
//			String query="CREATE TABLE employes (eid INT PRIMARY KEY,ename VARCHAR(30),salary DOUBLE,email VARCHAR(25),gender VARCHAR(10))";
//			String query = "INSERT INTO employes VALUES "
//                    + "(101,'nithin',9000.0,'tom@gmail.com','male'),"
//                    + "(102,'sharath',8000.0,'rom@gmail.com','male'),"
//                    + "(103,'harshini',8500.5,'sam@gmail.com','female'),"
//                    + "(104,'bharath',7800.2,'john@gmail.com','male'),"
//                    + "(105,'anish',9200.3,'david@gmail.com','male')";
//			state.execute(query);
			
			//updating one name based on id
//			String query="UPDATE employes SET ename='Nithin Gowda' WHERE eid=101";
			
			//updating name,email,salary of one employee on id
//			String query="UPDATE employes SET ename='Nithin', salary=12000, email='nithin@gmail.com' WHERE eid=101";
			
			//updating one person salary based on email
//			String query="UPDATE employes SET ename='Raju' WHERE email='sam@gmail.com'";
//			state.executeUpdate(query);
			
			//Fetching based on id
//			String query="SELECT * FROM employes WHERE eid=101";
			
			//fetching based on email
//			String query="SELECT * FROM employes WHERE email='david@gmail.com'";
//			state.execute(query);
//			ResultSet rs=state.getResultSet();
//			if(rs.next()) {
//				int eid=rs.getInt(1);
//				String ename=rs.getString("ename");
//				double salary=rs.getDouble(3);
//				String email=rs.getString(4);
//				String gender=rs.getString("gender");
//				System.out.println(eid+" "+ename+" "+salary+" "+email+" "+gender);
//			}else {
//				System.out.println("id is nort present");
//			}
			
			//fetching based on gender
//			String query="SELECT * FROM employes WHERE gender='male'";
//			state.execute(query);
//			ResultSet rs=state.getResultSet();
//			while(rs.next()) {
//				int eid=rs.getInt(1);
//				String ename=rs.getString("ename");
//				double salary=rs.getDouble(3);
//				String email=rs.getString(4);
//				String gender=rs.getString("gender");
//				System.out.println(eid+" "+ename+" "+salary+" "+email+" "+gender);
//			}
			
			//fetching all data
//			String query="SELECT * FROM employes";
//			state.execute(query);
//			ResultSet rs=state.getResultSet();
//			while(rs.next()) {
//				int eid=rs.getInt(1);
//				String ename=rs.getString("ename");
//				double salary=rs.getDouble(3);
//				String email=rs.getString(4);
//				String gender=rs.getString("gender");
//				System.out.println(eid+" "+ename+" "+salary+" "+email+" "+gender);
//			}
			
			//delete employe based on gender
//			String query="DELETE FROM employes WHERE gender='female'";
//			state.executeUpdate(query);
			//Step 5
			con.close();
			System.out.println("Task Completed Succesfully..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
