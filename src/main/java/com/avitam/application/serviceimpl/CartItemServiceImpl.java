package com.avitam.application.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.avitam.application.dao.CartDao;
import com.avitam.application.dao.CartItemDao;
import com.avitam.application.model.CartItem;
import com.avitam.application.service.CartItemService;

public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;
	
	public void setCartItemDao(CartItemDao cartItemDao) {
		this.cartItemDao= cartItemDao;
	}
	
	public CartItemServiceImpl() {
		System.out.println("CartItemservice bean created");
	}
	
	@Override
	public boolean addProductToCart(int cart_id, int product_id, int quantity) {
		CartItem cartItem=cartItemDao.getCartItemByProductAndId(cart_id, product_id);
		if(cartItem==null) {
			int rowsAffected=cartItemDao.createAndAddToCart(cart_id, product_id, quantity);
			if(rowsAffected!=0) {
				return true;
			}
		}else {
			int rowsAffected=cartItemDao.updateCartIfExists(cart_id, product_id, quantity);
			if(rowsAffected!=0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<CartItem> getCartItemsById(int cart_id) {
		return cartItemDao.getItemsByCartId(cart_id);
	}

	@Override
	public CartItem getById(int cartItemId) {
		return cartItemDao.getCartItemById(cartItemId);
	}

	@Override
	public void updateCart(int cartItemId, int quantity) {
       cartItemDao.updateCart(cartItemId, quantity);	
	}

	@Override
	public void removeItemById(int cartItemId) {
		cartItemDao.removeItem(cartItemId);
		
	}

}
