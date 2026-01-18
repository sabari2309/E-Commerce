package com.avitam.application.dao;

import java.util.List;

import com.avitam.application.model.CartItem;

public interface CartItemDao {
   CartItem getCartItemByProductAndId(int cart_id,int product_id);
   int createAndAddToCart(int cart_id,int product_id,int quantity );
   int updateCartIfExists(int cart_id,int product_id,int quantity);
   List<CartItem> getItemsByCartId(int cart_id);
   CartItem getCartItemById(int cartItemId);
   void updateCart(int cartItemId, int quantity);
   void removeItem(int cartItemId);
}
