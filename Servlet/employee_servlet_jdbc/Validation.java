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

@WebServlet("/validate")
public class Validation extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usn = req.getParameter("username");
		String pwd = req.getParameter("password");
		
		String realUsn="Admin@gmail.com";
		String realPwd="Admin@123";
		
		PrintWriter p=resp.getWriter();
		
		if(usn.equals(realUsn) && pwd.equals(realPwd)) {
			System.out.println("Login Success");	
			
			HttpSession s = req.getSession();
			//data coming from form store it in session obj
			s.setAttribute("usn", usn);
			s.setAttribute("pwd", pwd);
			resp.sendRedirect("home");
		}
		else {
			System.out.println("Login Failure");
			p.print("<h1>Login Failure</h1>");
			//include
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
	}
}
