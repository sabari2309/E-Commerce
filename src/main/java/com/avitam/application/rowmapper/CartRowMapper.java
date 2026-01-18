package com.avitam.application.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avitam.application.model.Cart;

public class CartRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart=new Cart();
		cart.setId(rs.getInt(1));
		cart.setUser_id(rs.getInt(2));
		cart.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
		return cart;
	}

}
