package com.fooddelivery.controller;

import java.io.IOException;
import com.fooddelivery.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fooddelivery.daoimpl.*;
import com.fooddelivery.dao.*;

/**
 * Servlet implementation class ResturantData
 */
@WebServlet("/addrestaurant")
public class ResturantData extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("rest_name");
		String Cusivie=req.getParameter("cusivine_Type");
		int delivery=Integer.parseInt(req.getParameter("time"));
		Boolean avaliable=Boolean.parseBoolean(req.getParameter("avaliable"));
		int Rating=Integer.parseInt(req.getParameter("rate"));
		
		Restaurant r=new Restaurant(id,name,Cusivie,delivery,avaliable,Rating);
		
		RestaurantDAO rdaoi=new RestaurantDAOImpl();
		
		int x=rdaoi.insert(r);
		
		if(x==0) {
			resp.sendRedirect("failure.html");
		}
		else
			resp.sendRedirect("success.html");
		
	}
	
	}
