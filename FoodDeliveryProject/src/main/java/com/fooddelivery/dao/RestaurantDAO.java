package com.fooddelivery.dao;

import java.util.List;


import com.fooddelivery.model.*;
public interface RestaurantDAO {

	int insert(Restaurant rest);
	List<Restaurant> fecthAll();
	Restaurant fecthById(int id);
	int updateById(Boolean active, int id);
	int deleteById(int id);
}
