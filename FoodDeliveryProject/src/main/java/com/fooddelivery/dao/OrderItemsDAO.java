package com.fooddelivery.dao;

import com.fooddelivery.model.*;

public interface OrderItemsDAO {

	int insert(OrderItems orderItems);
	OrderItems fecthById(int order_id);

}
