package com.first;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mango")
public class PageB extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is Page B");
		//to view data : getAttribute("key") ----- present in HttpServletRequest
		//non static ,take one String arg
		//return value for that particular key
		//but it return in Object format(supermost class)
		/*
		 * Object pi=req.getAttribute("pi-value"); 
		 * Object name=req.getAttribute("user-name"); 
		 * Object age=req.getAttribute("user-age");
		 */
		//Downcasting
		double pi=(Double)req.getAttribute("pi-value");
		String name=(String)req.getAttribute("user-name");
		int age=(Integer)req.getAttribute("user-age");
		System.out.println(pi+" "+name+" "+age);
		
	}
}