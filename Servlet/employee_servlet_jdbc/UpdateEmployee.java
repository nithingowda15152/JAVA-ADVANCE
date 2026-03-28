package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/updateEmp")
public class UpdateEmployee extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter out = res.getWriter();

        try {
            // 1. Read data from form
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");

            // 2. Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. Create connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_servlet_jdbc?createDatabaseIfNotExist=true","root","root");

            // 4. Create statement
            Statement st = con.createStatement();

            // 5. Execute update query
            int result = st.executeUpdate(
                "UPDATE employee SET name='" + name + "' WHERE id=" + id);

            // Output
            if (result > 0) {
                out.println("<h3>Record Updated Successfully</h3>");
                System.out.println("Updated Successfully");
            } else {
                out.println("<h3>No Record Found</h3>");
                System.out.println("No Record Found");
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }
    }
}