package com.avitam.application.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avitam.application.model.CartItem;

public class CartItemOnlyRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartItem cartItem=new CartItem();
		cartItem.setCartItem_id(rs.getInt(1));
		cartItem.setCart_id(rs.getInt(2));
		cartItem.setProduct_id(rs.getInt(3));
		cartItem.setQuantity(rs.getInt(4));
		
		return cartItem;
	}

}
