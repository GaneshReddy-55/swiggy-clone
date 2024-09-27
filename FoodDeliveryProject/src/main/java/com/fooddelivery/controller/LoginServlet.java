package com.fooddelivery.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fooddelivery.model.User;
import com.fooddelivery.dao.*;
import com.fooddelivery.daoimpl.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("pwd");
		
		User u=new User();
		UserDAO udaoi=new UserDAOImpl();
		
		u = udaoi.fecthByEmail(email);
		
		if(u != null) {
			if(password.equals(u.getPwd())) {
				session=req.getSession();
				session.setAttribute("user", u);
				resp.sendRedirect("home.jsp");
			}
			else
				resp.sendRedirect("incorrectpwd.jsp");
		}
		else
			resp.sendRedirect("register.html");
	}
}
