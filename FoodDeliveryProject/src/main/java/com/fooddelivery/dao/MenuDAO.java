package com.fooddelivery.dao;

import java.util.List;

import com.fooddelivery.model.*;

public interface MenuDAO {

	int insert(Menu m);
	List<Menu> getAllRestId(int rest_id);
	Menu getMenuById(int menu_id);
	int updateMenuById(int menu_id, boolean isavailable);
	int deleteMenuById(int menu_id);
}
