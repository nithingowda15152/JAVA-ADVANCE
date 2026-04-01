package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/display")
public class DisplayEmployee extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        int id = (int) req.getAttribute("id");
        String name = (String) req.getAttribute("name");
        String email = (String) req.getAttribute("email");
        String password = (String) req.getAttribute("password");
        double salary = (double) req.getAttribute("salary");

        // Console
        System.out.println("From Second Servlet:");
        System.out.println(id + " " + name + " " + email + " " + password + " " + salary);

        // Browser
        pw.println("<h2>Employee Details</h2>");
        pw.println("ID: " + id + "<br>");
        pw.println("Name: " + name + "<br>");
        pw.println("Email: " + email + "<br>");
        pw.println("Password: " + password + "<br>");
        pw.println("Salary: " + salary);
    }
}