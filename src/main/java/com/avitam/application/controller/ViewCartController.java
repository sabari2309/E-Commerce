package com.avitam.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.avitam.application.model.Address;
import com.avitam.application.model.Cart;
import com.avitam.application.model.CartItem;
import com.avitam.application.model.Category;
import com.avitam.application.model.Product;
import com.avitam.application.model.SubCategory;
import com.avitam.application.model.User;
import com.avitam.application.service.AddressService;
import com.avitam.application.service.CartItemService;
import com.avitam.application.service.CartService;

@Controller
@RequestMapping("/cart")

public class ViewCartController {
    
	@Autowired
	private CartService cartService;
	@Autowired
    private CartItemService cartItemService;
	@Autowired
	private AddressService addressService;
	@GetMapping("/view")
	public String addProduct(HttpSession session,Model model) {
		if (!isLoggedIn(session)) {
		    return "redirect:/login";
		}
		User user=(User) session.getAttribute("loggedUser");
        if(user==null) {
        	return "redirect:/login";
        }
        Cart cart=cartService.getCartByUserId(user.getUser_id());
        if(cart==null) {
        	model.addAttribute("cartItems",new ArrayList<>());
        	model.addAttribute("totalAmount", 0);
        	return "viewcart";
        }
        
        List<CartItem> cartItems=cartItemService.getCartItemsById(cart.getId());
        double totalAmount=0;
        for(CartItem cart1:cartItems) {
        	totalAmount+=cart1.getProduct().getPrice()*cart1.getQuantity();
        }
        model.addAttribute("cartItems",cartItems);
    	model.addAttribute("totalAmount",totalAmount);
		return "viewcart";
	}
	
	@GetMapping("/item/{cartItemId}/edit")
	public String cartEdit(@PathVariable int cartItemId,Model model) {
		CartItem cartItem=cartItemService.getById(cartItemId);
		model.addAttribute("cartItem", cartItem);
		return "update-cart-item";
	}
	
	@PostMapping("/item/update")
	public String updateCart(@RequestParam int cartItemId,@RequestParam int quantity) {
		cartItemService.updateCart(cartItemId,quantity);
		return "redirect:/cart/view";
	}
	
	@PostMapping("/item/remove")
	public String removeItem(@RequestParam int cartItemId) {
		cartItemService.removeItemById(cartItemId);
		return "redirect:/cart/view";
	}
	
	@PostMapping("/checkout")
	public String checkOut(Model model,@RequestParam int[] selectedItems,HttpSession session) {
		if (!isLoggedIn(session)) {
		    return "redirect:/login";
		}
		User user=(User)session.getAttribute("loggedUser");
		List<CartItem> items=cartItemService.getCartItemsByIds(selectedItems);
		session.setAttribute("selectedItems", items);
		double total=0;
		for(CartItem item:items) {
			total+=item.getProduct().getPrice()*item.getQuantity();
		}
		session.setAttribute("checkoutTotal", total);
		List<Address> addresses=addressService.getAddressByUserId(user.getUser_id());
		model.addAttribute("items", items);
		model.addAttribute("total",total);
		model.addAttribute("addresses", addresses);
		return "checkout";
	}
	
	@GetMapping("/checkout")
	public String showCheckoutPage(HttpSession session, Model model) {
		if (!isLoggedIn(session)) {
		    return "redirect:/login";
		}
	    User user = (User) session.getAttribute("loggedUser");
	    List<CartItem> items =
	        (List<CartItem>) session.getAttribute("selectedItems");

	    double total =
	        (double) session.getAttribute("checkoutTotal");

	    List<Address> addresses =
	        addressService.getAddressByUserId(user.getUser_id());

	    model.addAttribute("items", items);
	    model.addAttribute("total", total);
	    model.addAttribute("addresses", addresses);

	    return "checkout"; 
	}
	private boolean isLoggedIn(HttpSession session) {
	    return session.getAttribute("loggedUser") != null;
	}

}
