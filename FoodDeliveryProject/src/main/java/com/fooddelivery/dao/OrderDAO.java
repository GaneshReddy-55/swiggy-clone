package com.fooddelivery.dao;

import com.fooddelivery.model.Order;

public interface OrderDAO {
	
	int insert(Order order);
	Order fecthById(int order_id);
	int updateById(int ord_id, String status);
}
