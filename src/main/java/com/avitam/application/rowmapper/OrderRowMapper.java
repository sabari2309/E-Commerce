package com.avitam.application.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avitam.application.model.Order;

public class OrderRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order=new Order();
		order.setOrder_id(rs.getInt(1));
		order.setUser_id(rs.getInt(2));
		order.setAddress_id(rs.getInt(3));
		order.setTotal_amount(rs.getInt(4));
		order.setStatus(rs.getString(5));
		order.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
		return order;
	}

}
