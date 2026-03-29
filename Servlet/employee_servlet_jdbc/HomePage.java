package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/home")
public class HomePage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		String usn=(String)s.getAttribute("usn");
		String pwd=(String)s.getAttribute("pwd");
		PrintWriter p=resp.getWriter();
		if(usn != null && pwd != null) {
		    System.out.println("Home Page");
		    p.print("<h1>Welcome " + usn + "</h1>");
		    p.print("<br><br>");
		    p.print("<a href='logout'>Logout</a>");
		}
		else {
			System.out.println("Login First");
			p.print("<h1>Login First</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
	}
}
