package com.avitam.application.dao;

import java.util.List;

import com.avitam.application.model.OrderItem;

public interface OrderItemDao {
    void insertOrderItem(OrderItem orderItem);

	List<OrderItem> getOrderItems(int orderId);
}
