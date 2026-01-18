package com.avitam.application.dao;

import com.avitam.application.model.Cart;

public interface CartDao {
    Cart fetchCartByUserId(int user_id);

	Cart createCartAndReturn(int user_id);
}
