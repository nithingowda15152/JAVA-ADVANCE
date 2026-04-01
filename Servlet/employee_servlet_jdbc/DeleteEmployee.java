package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/deleteEmp")
public class DeleteEmployee extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter out = res.getWriter();

        try {
            // 1. Read ID
            String idStr = req.getParameter("id");

            if (idStr == null || idStr.isEmpty()) {
                out.println("<h3>Please enter ID!</h3>");
                return;
            }

            int id = Integer.parseInt(idStr);

            // 2. Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. Connection
            Connection con = DriverManager.getConnection(
            	"jdbc:mysql://localhost:3306/employee_servlet_jdbc?createDatabaseIfNotExist=true",
                "root",
                "root");

            // 4. Statement
            Statement st = con.createStatement();

            // 5. Execute DELETE query
            int result = st.executeUpdate(
                "DELETE FROM employee WHERE id=" + id);

            // 6. Output
            if (result > 0) {
                out.println("<h3>Record Deleted Successfully</h3>");
                System.out.println("Deleted Successfully");
            } else {
                out.println("<h3>No Record Found</h3>");
                System.out.println("No Record Found");
            }

            con.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }
    }
}