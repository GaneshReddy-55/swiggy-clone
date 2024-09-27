package com.fooddelivery.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.OrderItemsDAO;
import com.fooddelivery.model.*;

public class OrderItemsDAOImpl implements OrderItemsDAO{
	
	private static String insert="insert into order_items(order_id, menu_id, quantity, sub_tot) values(?,?,?,?)";
	private static String fecthspecific="select * from order_items where order_id=?";
	
	private static String url="jdbc:mysql://localhost:3306/fooddelivery";
	private static String user="root";
	private static String pwd="Gani@2002";
	
	private static Connection con;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet result;
	int x=-1;

static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,user,pwd);
	}
	catch(SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
}
	ArrayList<OrderItems> al=new ArrayList<>();
	OrderItems orderitems;



	@Override
	public int insert(OrderItems oi) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, oi.getOrder_id());
			pstmt.setInt(2,oi.getMenu_id());
			pstmt.setInt(3, oi.getQuantity());
			pstmt.setInt(4,oi.getSub_tot());
			
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public OrderItems fecthById(int order_id) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(fecthspecific);
			pstmt.setInt(1, order_id);
			result=pstmt.executeQuery();
			
			al=(ArrayList<OrderItems>) extract(result);
			orderitems=al.get(0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return orderitems;
	}
	
	public List<OrderItems> extract(ResultSet result) {
		try {
			while(result.next()) {
				al.add(new OrderItems(result.getInt(1),
						result.getInt(2),
						result.getInt(3),
						result.getInt(4),
						result.getInt(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return al;
	}

	
}
