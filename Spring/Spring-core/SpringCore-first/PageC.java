package com.first;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pageC")
public class PageC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("This is Page C");

        // read data from form
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        // store using setAttribute
        req.setAttribute("id", id);
        req.setAttribute("name", name);
        req.setAttribute("email", email);
        req.setAttribute("password", password);
        req.setAttribute("phone", phone);

        // forward to PageD
        RequestDispatcher rd = req.getRequestDispatcher("pageD");
        rd.forward(req, resp);
    }
}