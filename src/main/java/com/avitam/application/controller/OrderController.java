package com.avitam.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avitam.application.dto.OrderDTO;
import com.avitam.application.dto.OrderItemDTO;
import com.avitam.application.model.Address;
import com.avitam.application.model.Order;
import com.avitam.application.model.OrderItem;
import com.avitam.application.model.Product;
import com.avitam.application.model.User;
import com.avitam.application.service.AddressService;
import com.avitam.application.service.OrderService;
import com.avitam.application.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/vieworder")
	public String viewOrders(HttpSession session,Model model) {
		User user=(User)session.getAttribute("loggedUser");
		System.out.println(user);
		List<Order> orders = orderService.getOrdersByUserId(user.getUser_id());
		System.out.println("size:"+orders.size());
		List<OrderDTO> orderDetails=orderService.getOrderDetails(orders);
        model.addAttribute("orders", orderDetails);
        return "orders";   
	}
	
	@PostMapping("/orders/details")
	public String orderDetails(@RequestParam int orderId,Model model) {
		List<OrderItem> orderItems=orderService.getOrderItemByOrderId(orderId);
		List<OrderItemDTO> orderedProducts=orderService.getOrderedProducts(orderItems);
		OrderDTO order=orderService.getDetailsByOrderId(orderId);
		model.addAttribute("order", order);
		model.addAttribute("items", orderedProducts);
		return "order-details";
	}
}
