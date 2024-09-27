package com.fooddelivery.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.MenuDAO;
import com.fooddelivery.model.Menu;
//import com.tap.model.menu.Menu;

public class MenuDAOImpl implements MenuDAO{

	private static String insertall="insert into menu(menu_id,rest_id,item_name,description,price,isAvailable) values(?,?,?,?,?,?)";
	private static String fecthspecific="select * from menu where menu_id=?";
	private static String update="update menu set isAvailable=? where menu_id=?";
	private static String delete="delete from menu where menu_id=?";
	private static String fetchByRestId="select * from menu where rest_id=?";
	
	private static String url="jdbc:mysql://localhost:3306/fooddelivery";
	private static String user="root";
	private static String pwd="Gani@2002";
	
	private static Connection con;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	static ResultSet result;
	int x=-1;
	ArrayList<Menu> al=new ArrayList<>();
	Menu menu;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pwd);
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insert(Menu m) {
		try {
			pstmt=con.prepareStatement(insertall);
			pstmt.setInt(1, m.getMenu_id());
			pstmt.setInt(2,m.getRest_id());
			pstmt.setString(3, m.getItem_name());
			pstmt.setString(4, m.getDescription());
			pstmt.setFloat(5,m.getPrice());
			pstmt.setBoolean(6, m.isAvailable());
			
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<Menu> getAllRestId(int rest_id) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement(fetchByRestId);
			pstmt.setInt(1, rest_id);
			result=pstmt.executeQuery();
			
			al=(ArrayList<Menu>) extract(result);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public Menu getMenuById(int menu_id) {
		try {
			pstmt=con.prepareStatement(fecthspecific);
			pstmt.setInt(1, menu_id);
			result=pstmt.executeQuery();
			
			al=(ArrayList<Menu>) extract(result);
			menu=al.get(0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public int updateMenuById(int menu_id, boolean isavailable) {
		
			try {
			pstmt=con.prepareStatement(update);
			pstmt.setBoolean(1, isavailable);
			pstmt.setInt(2, menu_id);
			x=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int deleteMenuById(int menu_id) {
		
		try {
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1, menu_id);
			
			x=pstmt.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
				e.printStackTrace();
		}
		return x;
	}
	
	public List<Menu> extract(ResultSet result){
		try {
			while(result.next()) {
				al.add(new Menu(result.getInt(1),
						result.getString(3),
						result.getString(4),
						result.getFloat(5),
						result.getBoolean(6)));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return al;
	}


	
}
