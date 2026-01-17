package com.avitam.application.service;

import java.util.List;

import com.avitam.application.model.CartItem;

public interface CartItemService {
   boolean addProductToCart(int cart_id,int product_id,int quantity);

   List<CartItem> getCartItemsById(int id);

   CartItem getById(int cartItemId);

   void updateCart(int cartItemId, int quantity);

  void removeItemById(int cartItemId);
}
