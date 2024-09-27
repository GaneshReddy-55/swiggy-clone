package com.fooddelivery.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.OrderDAO;
import com.fooddelivery.model.Order;

public class OrderDAOImpl implements OrderDAO{

	private static String insert="insert into order1(user_id, rest_id, total_amt, status, date, payment_option) values(?,?,?,?,?,?)";
	private static String fecthspecific="select * from order1 where order_id=?";
	private static String update="update order1 set status=? where order_id=?";
	
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
	ArrayList<Order> al=new ArrayList<>();
	Order order;

	@Override
	public int insert(Order o) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, o.getUser_id());
			pstmt.setInt(2,o.getRest_id());
			pstmt.setInt(3, o.getTot_amt());
			pstmt.setString(4,o.getStatus());
			pstmt.setString(5, o.getDate());
			pstmt.setString(6, o.getPayment_option());
			
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public Order fecthById(int order_id) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(fecthspecific);
			pstmt.setInt(1, order_id);
			result=pstmt.executeQuery();
			
			al=(ArrayList<Order>) extract(result);
			order=al.get(0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public int updateById(int ord_id, String status) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, status);
			pstmt.setInt(2, ord_id);
			
			x=pstmt.executeUpdate(); 
		  } catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
			return x;
	}

	public List<Order> extract(ResultSet result) {
		try {
			while(result.next()) {
				al.add(new Order(result.getInt(1),
						result.getInt(2),
						result.getInt(3),
						result.getInt(4),
						result.getString(5),
						result.getString(6),
						result.getString(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return al;
	}

	

}
