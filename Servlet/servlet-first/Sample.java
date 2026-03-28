package com.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hii")
public class Sample extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. Print in console
		System.out.println("Welcome to Servlets");
		// 2. print some message on browser
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.print("<html><body>");
		pw.print("<h1>Hello All</h1>");
		pw.print("</body></html>");
	}
}