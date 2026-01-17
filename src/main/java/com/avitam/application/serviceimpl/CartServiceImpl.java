package com.avitam.application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.avitam.application.dao.CartDao;
import com.avitam.application.model.Cart;
import com.avitam.application.service.CartService;

public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	public CartServiceImpl() {
		System.out.println("Cartservice bean created");
	}
	
	@Override
	public Cart getCartByUserId(int user_id) {
		Cart cart=cartDao.fetchCartByUserId(user_id);
		if(cart==null) {
			cart=cartDao.createCartAndReturn(user_id);
		}
		return cart;
	}

}
