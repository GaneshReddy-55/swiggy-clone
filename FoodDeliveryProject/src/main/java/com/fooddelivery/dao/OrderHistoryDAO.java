package com.fooddelivery.dao;

import com.fooddelivery.model.*;

public interface OrderHistoryDAO {

	int insertOrderHistory(OrderHistory oh);
	OrderHistory fecthOrderOnId(int userId);
	int updateOrderHistory(int ohid, String status);
}
