package com;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logingin")
public class ValidationEmploye extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_servlet_jdbc?createDatabaseIfNotExist=true","root","root");
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM employee WHERE email=? AND password=?"
            );
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // VALID USER--Store it in Session
            	HttpSession session = req.getSession();
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                pw.println("<h2>Login Successful</h2>");
                pw.println("<h3>Email & Password stored in session</h3>");
            } else {
                // INVALID USER
                pw.println("<h2>Invalid Email or Password</h2>");
            }
            con.close();
        } catch (Exception e) {
            pw.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}