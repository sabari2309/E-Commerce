package com.avitam.application.service;

import com.avitam.application.model.Cart;

public interface CartService {
   Cart getCartByUserId(int user_id);
}
