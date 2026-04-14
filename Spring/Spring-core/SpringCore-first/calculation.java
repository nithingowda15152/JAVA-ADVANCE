package com.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/calc")
public class calculation extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            // Read values
            String i1 = req.getParameter("int1");
            String i2 = req.getParameter("int2");
            String d1 = req.getParameter("dec1");
            String d2 = req.getParameter("dec2");

            // Convert (Parsing)
            int a = Integer.parseInt(i1);
            int b = Integer.parseInt(i2);

            double x = Double.parseDouble(d1);
            double y = Double.parseDouble(d2);

            // Integer operations
            int add = a + b;
            int sub = a - b;
            int mul = a * b;
            int div = a / b;
            int mod = a % b;

            // Decimal operations
            double dadd = x + y;
            double dsub = x - y;
            double dmul = x * y;
            double ddiv = x / y;

            // Output
            out.println("<h2>Results</h2>");

            out.println("<h3>Integer Operations</h3>");
            out.println("Addition: " + add + "<br>");
            out.println("Subtraction: " + sub + "<br>");
            out.println("Multiplication: " + mul + "<br>");
            out.println("Division: " + div + "<br>");
            out.println("Modulus: " + mod + "<br>");

            out.println("<h3>Decimal Operations</h3>");
            out.println("Addition: " + dadd + "<br>");
            out.println("Subtraction: " + dsub + "<br>");
            out.println("Multiplication: " + dmul + "<br>");
            out.println("Division: " + ddiv + "<br>");

        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Enter valid numbers!</h3>");
        }
    }
}