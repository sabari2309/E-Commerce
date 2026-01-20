package com.avitam.application.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avitam.application.model.OrderItem;

public class OrderItemRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderItem obj=new OrderItem();
		obj.setOrder_item_id(rs.getInt(1));
		obj.setOrder_id(rs.getInt(2));
		obj.setProduct_id(rs.getInt(3));
		obj.setQuantity(rs.getInt(4));
		obj.setPrice(rs.getInt(5));
		return obj;
	}

}
