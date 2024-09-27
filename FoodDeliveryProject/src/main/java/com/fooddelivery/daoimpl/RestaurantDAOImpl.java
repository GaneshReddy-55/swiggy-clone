package com.fooddelivery.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.RestaurantDAO;
import com.fooddelivery.model.*;

public class RestaurantDAOImpl implements RestaurantDAO {

	private static String insertall="insert into resturant(id,name,cuisive_Type,delivery_time,IsActive,Rating) values(?,?,?,?,?,?)";
	private static String fecthAll="select * from resturant";
	private static String fecthspecific="select * from resturant where id=?";
	private static String update="update resturant set IsActive=? where id=?";
	private static String delete="delete from resturant where id=?";
	
	private static String url="jdbc:mysql://localhost:3306/fooddelivery";
	private static String user="root";
	private static String pwd="Gani@2002";
	
	private static Connection con;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet result;
	int x=-1;
	ArrayList<Restaurant> al=new ArrayList<>();
	Restaurant restaurant;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pwd);
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int insert(Restaurant rest) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(insertall);
			pstmt.setInt(1, rest.getId());
			pstmt.setString(2,rest.getName());
			pstmt.setString(3, rest.getCuisive_Type());
			pstmt.setInt(4,rest.getDelivery_time());
			pstmt.setBoolean(5, rest.isActive());
			pstmt.setInt(6, rest.getRating());
			
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return x;
	}
	@Override
	public List<Restaurant> fecthAll() {
		// TODO Auto-generated method stub
		try {
			stmt=con.createStatement();
			result=stmt.executeQuery(fecthAll);
			
			al=(ArrayList<Restaurant>) extract(result);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return al;
	}
	@Override
	public Restaurant fecthById(int id) {
		try {
			pstmt=con.prepareStatement(fecthspecific);
			pstmt.setInt(1, id);
			result=pstmt.executeQuery();
			al=(ArrayList<Restaurant>) extract(result);
			restaurant=al.get(0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return restaurant;
	}
	@Override
	public int updateById(Boolean active, int id) {
			try {
			
			pstmt=con.prepareStatement(update);
			pstmt.setBoolean(1, active);
			pstmt.setInt(2, id);
			x=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return x;
	}
	@Override
	public int deleteById(int id) {
		try {
		pstmt=con.prepareStatement(delete);
		pstmt.setInt(1, id);
		
		x=pstmt.executeUpdate();
		} catch (SQLException e) {
		// TODO: handle exception
			e.printStackTrace();
	}
		return x;
	}
	
	public List<Restaurant> extract(ResultSet result){
		try {
			while(result.next()) {
				al.add(new Restaurant(result.getInt(1),result.getString(2),
				result.getString(3),result.getInt(4),
				result.getBoolean(5),result.getInt(6)));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return al;
	}
}
