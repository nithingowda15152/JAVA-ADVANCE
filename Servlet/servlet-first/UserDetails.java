package com.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/details")
public class UserDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        // 1. Declare variables
        String name = "Nithin";
        int age = 22;
        long phoneNum = 636360350;

        // 2. Print in console
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phoneNum);

        // 3. Print in browser
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.print("<html><body>");
        pw.print("<h2>User Details</h2>");
        pw.print("<p>Name: " + name + "</p>");
        pw.print("<p>Age: " + age + "</p>");
        pw.print("<p>Phone: " + phoneNum + "</p>");
        pw.print("</body></html>");
    }
}