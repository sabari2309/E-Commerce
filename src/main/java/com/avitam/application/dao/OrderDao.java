package com.avitam.application.dao;

import java.util.List;

import com.avitam.application.model.Order;
import com.avitam.application.model.OrderItem;

public interface OrderDao {
   int createOrder(int user_id, int addressId, double total);

   List<Order> getOrderByUser(int user_id);

   List<OrderItem> getOrderByOrderId(int orderId);

   Order getDetailsByOrderId(int orderId);
}
