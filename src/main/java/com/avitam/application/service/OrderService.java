package com.avitam.application.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.avitam.application.dto.OrderDTO;
import com.avitam.application.dto.OrderItemDTO;
import com.avitam.application.model.Order;
import com.avitam.application.model.OrderItem;

public interface OrderService {

  int placeOrder(int user_id, int[] cartItemsIds, double total, int addressId, HttpSession session);
  List<Order> getOrdersByUserId(int user_id);
  List<OrderItem> getOrderItemByOrderId(int orderId);
  OrderDTO getDetailsByOrderId(int orderId);
  List<OrderItemDTO> getOrderedProducts(List<OrderItem> orderItems);
  List<OrderDTO> getOrderDetails(List<Order> orders);
}
