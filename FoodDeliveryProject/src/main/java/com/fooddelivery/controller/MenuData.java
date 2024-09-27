package com.fooddelivery.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.model.Menu;

import com.fooddelivery.dao.*;
import com.fooddelivery.daoimpl.MenuDAOImpl;
/**
 * Servlet implementation class MenuData
 */
@WebServlet("/menudata")
public class MenuData extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menuId=Integer.parseInt(req.getParameter("menuid"));
		int restaurantId=Integer.parseInt(req.getParameter("RestaurantId"));
		String itemname=req.getParameter("ItemName");
		String description=req.getParameter("description");
		float price=Float.parseFloat(req.getParameter("price"));
		boolean available=Boolean.parseBoolean(req.getParameter("available"));
		
		Menu m=new Menu(menuId,restaurantId,itemname,description,price,available);
		
		MenuDAO mdaoi=new MenuDAOImpl();
		
		int x=mdaoi.insert(m);
		
		if(x==0) {
			resp.sendRedirect("failure.html");
		}
		else
			resp.sendRedirect("success.html");
		
	}
}
