 package com.fooddelivery.daoimpl;

import java.sql.Connection;
import com.fooddelivery.model.User;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivery.dao.UserDAO;
//import com.tap.model.user.User;

public class UserDAOImpl implements UserDAO{

	private static String insert="insert into user(name,email,pwd,address) values(?,?,?,?)";
	private static String fecthAll="select * from user";
	private static String fecthspecific="select * from user where email=?";
	private static String update="update user set pwd=? where name=?";
	private static String delete="delete from user where id=?";
	
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
	ArrayList<User> al=new ArrayList<>();
	User u;
	@Override
	public int insert(User u) {
		try {
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, u.getName());
			pstmt.setString(2,u.getEmail());
			pstmt.setString(3, u.getPwd());
			pstmt.setString(4,u.getAddress());
			
			x=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<User> fecthAll() {
		// TODO Auto-generated method stub
		try {
			stmt=con.createStatement();
			result=stmt.executeQuery(fecthAll);
			
			al=(ArrayList<User>) extract(result);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public User fecthByEmail(String email) {
		
		try {
			pstmt=con.prepareStatement(fecthspecific);
			pstmt.setString(1, email);
			result=pstmt.executeQuery();
			
			al=(ArrayList<User>) extract(result);
			if(al==null) {
				u=null;
			}
			else
				u=al.get(0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int updateByName(String pwd, String name) {
		try {
		pstmt=con.prepareStatement(update);
		pstmt.setString(1, pwd);
		pstmt.setString(2, name);
		
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
				e.printStackTrace();
		}
		return x;
	}
	
	public List<User> extract(ResultSet result) {
		int c=0;
		try {
			while(result.next()) {
				c=1;
				al.add(new User(result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		if(c==0) {
			return null;
		}
		return al;
	}



}
