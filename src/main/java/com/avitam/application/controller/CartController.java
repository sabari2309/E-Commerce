package com.avitam.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.avitam.application.model.Cart;
import com.avitam.application.model.Product;
import com.avitam.application.model.User;
import com.avitam.application.service.CartItemService;
import com.avitam.application.service.CartService;

@Controller
public class CartController {
     
	@Autowired
	private CartService cartService;
	@Autowired
	private CartItemService cartItemService;
	
	@PostMapping("cart/items/add")
	public String cartcontrol(@RequestParam int productId,@RequestParam int quantity,HttpSession session,RedirectAttributes redirectAttributes) {
		User user=(User)session.getAttribute("loggedUser");
		Cart cart=cartService.getCartByUserId(user.getUser_id());
		cartItemService.addProductToCart(cart.getId(), productId, quantity);
		return "redirect:/cart/view";
	}
	
	
}
