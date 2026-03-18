package com.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert5Rows{

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/first-jdbc-db?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "root";

        try {

            // STEP 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // STEP 2: Create Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // STEP 3: Create Statement
            Statement state = con.createStatement();

            // STEP 4: Write Query
            String query = "INSERT INTO student VALUES "
                    + "(107,'nithin',90.0,'tom@gmail.com'),"
                    + "(102,'Rom',80.0,'rom@gmail.com'),"
                    + "(103,'Sam',85.5,'sam@gmail.com'),"
                    + "(104,'John',78.2,'john@gmail.com'),"
                    + "(105,'David',92.3,'david@gmail.com')";

            // Execute Query
            state.execute(query);

            // STEP 5: Close Connection
            con.close();

            System.out.println("Rows Inserted Successfully");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}