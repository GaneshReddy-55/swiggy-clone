package com.fooddelivery.controller;
import com.fooddelivery.daoimpl.*;
import java.io.IOException;
import com.fooddelivery.dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/addUser")
public class RegisterUser extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		
		User u = new User(username,email,password,address);
		
		UserDAO udaoi=new UserDAOImpl();
		
		int x=udaoi.insert(u);
		
		if(x==0) {
			resp.sendRedirect("failure.html");
		}
		else
			resp.sendRedirect("success.html");
	}
}
