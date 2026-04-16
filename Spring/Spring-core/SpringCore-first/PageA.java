package com.first;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * RequestDispatcher : interface present in javax.servlet package
 * used to transfer request from one file to another file
 * file(.java/.html/.jsp)
 */
//One servlet class to another servlet class

//execute : start server--give apple url
@WebServlet("/apple")
public class PageA extends  HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is Page A");
		//execute PageB from PageA
		
		//transfering data also
		//set the data---setAttribute(K,V) : present in HttpServletRequest
		//non static method
		//2 things :Key,Value
		//key:String		Value:AnyDatatype
		req.setAttribute("pi-value", 3.142);
		req.setAttribute("user-name", "ROSE");
		req.setAttribute("user-age", 25);
			
		
		//transfer req from PageA to PageB using RD
		//get RD object?
		/*
		 * call getRequestDispatcher()---present in HttpServletRequest(interface)
		 * non static method
		 * give RD obj
		 * accept String arg
		 */
		RequestDispatcher rd=req.getRequestDispatcher("mango");//url of PageB servlet class
		//call forward()
		rd.forward(req, resp);
	}
}