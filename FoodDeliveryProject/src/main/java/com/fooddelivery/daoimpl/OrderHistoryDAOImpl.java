package com.fooddelivery.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.OrderHistoryDAO;
//import com.tap.model.Order.OrderHistory;
import com.fooddelivery.model.*;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

	private static String insert="insert into order_history(user_id, order_id, total_amt, date, status) values(?,?,?,?,?)";
	private static String fecthspecific="select * from order_history where user_id=?";
	private static String update="update order_history set status=? where order_history_id=?";
	
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
	ArrayList<OrderHistory> al=new ArrayList<>();
	OrderHistory orderhistory;


	@Override
	public int insertOrderHistory(OrderHistory oh) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, oh.getUserId());
			pstmt.setInt(2,oh.getOrderId());
			pstmt.setInt(3, oh.getTot_amt());
			pstmt.setString(5,oh.getStatus());
			pstmt.setString(4, oh.getDate());
			
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
		
	}

	@Override
	public OrderHistory fecthOrderOnId(int userId) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(fecthspecific);
			pstmt.setInt(1, userId);
			result=pstmt.executeQuery();
			
			al=(ArrayList<OrderHistory>) extract(result);
			orderhistory=al.get(0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return orderhistory;
	}

	@Override
	public int updateOrderHistory(int ohid, String status) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, status);
			pstmt.setInt(2, ohid);
			
			x=pstmt.executeUpdate(); 
		  } catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
			return x;
		
		}
		
	
	public List<OrderHistory> extract(ResultSet result) {
		try {
			while(result.next()) {
				al.add(new OrderHistory(result.getInt(1),
						result.getInt(2),
						result.getInt(3),
						result.getString(4),
						result.getInt(5),
						result.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return al;
	}

	
}
