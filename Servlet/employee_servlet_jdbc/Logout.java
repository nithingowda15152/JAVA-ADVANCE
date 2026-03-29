package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//remove data from session obj
		HttpSession s1 = req.getSession();
		s1.invalidate();
		PrintWriter p=resp.getWriter();
		System.out.println("Logout Successsfull");
		p.print("<h1>Logout Success</h1>");
	}
}
