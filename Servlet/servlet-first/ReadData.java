package com.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/read")
public class ReadData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //Get values using SAME names as HTML
        String name = req.getParameter("username");
        String age = req.getParameter("userage");
        String phone = req.getParameter("userphone");

        //Print in console
        System.out.println(name + " " + age + " " + phone);

        //Print in browser
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.print("<html><body>");
        pw.print("<h2>User Details</h2>");
        pw.print("<p>Name: " + name + "</p>");
        pw.print("<p>Age: " + age + "</p>");
        pw.print("<p>Phone: " + phone + "</p>");
        pw.print("</body></html>");
        pw.close();
        
        //Printing in browser based on its dataType
        int age1=Integer.parseInt(age);
        long phone1=Long.parseLong(phone);
        }
}