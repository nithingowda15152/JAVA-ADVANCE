package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class RegisterEmployee extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        try {
            // Read data
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            double salary = Double.parseDouble(req.getParameter("salary"));
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_servlet_jdbc?createDatabaseIfNotExist=true", "root","root");

            // PrepareStatement
            PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?, ?)");

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setDouble(5, salary);

            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("<h2>Employee Registered Successfully!</h2>");
            } else {
                out.println("<h2>Failed!</h2>");
            }
            con.close();

        } catch (Exception e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}