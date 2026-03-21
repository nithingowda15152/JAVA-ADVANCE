package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentImplementation implements StudentInterface {

	String url = "jdbc:mysql://localhost:3306/third-jdbc-db";
	String user = "root";
	String password = "root";

	Scanner sc = new Scanner(System.in);

	// 1. Insert
	@Override
	public void addStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			String query = "insert into student(id,name,marks) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			System.out.println("Enter ID:");
			int id = sc.nextInt();

			System.out.println("Enter Name:");
			String name = sc.next();

			System.out.println("Enter Marks:");
			double marks = sc.nextDouble();

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, marks);

			ps.executeUpdate();

			con.close();

			System.out.println("Student Inserted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2. Update
	@Override
	public void updateStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			String query = "update student set marks=? where id=?";
			PreparedStatement ps = con.prepareStatement(query);

			System.out.println("Enter Student ID:");
			int id = sc.nextInt();

			System.out.println("Enter New Marks:");
			double marks = sc.nextDouble();

			ps.setDouble(1, marks);
			ps.setInt(2, id);

			ps.executeUpdate();

			con.close();

			System.out.println("Student Updated Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3. Delete One Student
	@Override
	public void removeStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			String query = "delete from student where id=?";
			PreparedStatement ps = con.prepareStatement(query);

			System.out.println("Enter Student ID:");
			int id = sc.nextInt();

			ps.setInt(1, id);

			ps.executeUpdate();

			con.close();

			System.out.println("Student Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 4. Display One Student
	@Override
	public void displayStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			String query = "select * from student where id=?";
			PreparedStatement ps = con.prepareStatement(query);

			System.out.println("Enter Student ID:");
			int id = sc.nextInt();

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getInt("id") + " "
						+ rs.getString("name") + " "
						+ rs.getDouble("marks"));
			} else {
				System.out.println("Student Not Found");
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 5. Display All Students
	@Override
	public void displayAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			String query = "select * from student";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " "
						+ rs.getString("name") + " "
						+ rs.getDouble("marks"));
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 6. Delete All Students
	@Override
	public void removeAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			String query = "delete from student";
			PreparedStatement ps = con.prepareStatement(query);

			ps.executeUpdate();

			con.close();

			System.out.println("All Students Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 7. Count Students
	@Override
	public void countStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			String query = "select count(*) from student";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Total Students: " + rs.getInt(1));
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 8. Sort Students Based on Marks
	@Override
	public void sortStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			String query = "select * from student order by marks";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " "
						+ rs.getString("name") + " "
						+ rs.getDouble("marks"));
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 9. Student With Highest Marks
	@Override
	public void findStudentWithHighestMarks() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			String query = "select * from student order by marks desc limit 1";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Highest Marks Student:");
				System.out.println(rs.getInt("id") + " "
						+ rs.getString("name") + " "
						+ rs.getDouble("marks"));
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 10. Student With Lowest Marks
	@Override
	public void findStudentWithLowestMarks() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			String query = "select * from student order by marks asc limit 1";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Lowest Marks Student:");
				System.out.println(rs.getInt("id") + " "
						+ rs.getString("name") + " "
						+ rs.getDouble("marks"));
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}