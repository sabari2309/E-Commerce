package com.avitam.application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avitam.application.model.Address;
import com.avitam.application.model.CartItem;
import com.avitam.application.model.OrderItem;
import com.avitam.application.model.User;
import com.avitam.application.service.AddressService;
import com.avitam.application.service.CartItemService;

import com.avitam.application.service.OrderService;
import com.mysql.cj.Session;

@Controller
//@ResponseBody
public class CheckoutController {
 
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/address/add")
	public String addAddress(Address address,HttpSession session,Model model) {
		if (!isLoggedIn(session)) {
		    return "redirect:/login";
		}
		User user=(User)session.getAttribute("loggedUser");
		address.setUser_id(user.getUser_id());
		boolean status=addressService.addAddress(address);
		return "redirect:/cart/checkout";
	}
	
	@PostMapping("/order/place")
	public String placeOrder(@RequestParam int[] cartItemIds,@RequestParam double total,@RequestParam int addressId,HttpSession session,Model model) {
		if (!isLoggedIn(session)) {
		    return "redirect:/login";
		}
		User user=(User)session.getAttribute("loggedUser");
		
		int orderId=orderService.placeOrder(user.getUser_id(),cartItemIds,total,addressId,session);
		model.addAttribute("user", user);
		model.addAttribute("orderId", orderId);
		return "order-success";
	}
	private boolean isLoggedIn(HttpSession session) {
	    return session.getAttribute("loggedUser") != null;
	}
}
