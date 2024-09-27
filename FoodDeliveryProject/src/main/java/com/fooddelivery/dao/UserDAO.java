package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.User;

public interface UserDAO {

	int insert(User user);
	List<User> fecthAll();
	User fecthByEmail(String email);
	int updateByName(String pwd, String name);
	int deleteById(int id);
}
