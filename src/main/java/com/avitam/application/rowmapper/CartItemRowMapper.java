package com.avitam.application.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avitam.application.model.CartItem;
import com.avitam.application.model.Product;

public class CartItemRowMapper implements RowMapper {

	@Override
	public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartItem cartItem=new CartItem();
		cartItem.setCartItem_id(rs.getInt(1));
		cartItem.setCart_id(rs.getInt(2));
		cartItem.setProduct_id(rs.getInt(3));
		cartItem.setQuantity(rs.getInt(4));
		
		Product product=new Product();
		product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        product.setImage(rs.getString("image"));
        cartItem.setProduct(product);
        
        return cartItem;
	    
	}

}
