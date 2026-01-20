package com.avitam.application.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.avitam.application.dao.OrderItemDao;
import com.avitam.application.model.OrderItem;
import com.avitam.application.rowmapper.OrderItemRowMapper;

public class OrderItemDaoImpl implements OrderItemDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertOrderItem(OrderItem orderItem) {
		String sql="insert into order_items (order_id,product_id,quantity,price) values (?,?,?,?)";
		jdbcTemplate.update(sql,orderItem.getOrder_id(),orderItem.getProduct_id(),orderItem.getQuantity(),orderItem.getPrice());
		
	}

	@Override
	public List<OrderItem> getOrderItems(int orderId) {
		String sql="select order_item_id,order_id,product_id,quantity,price from order_items where order_id=?";
		
		return (List<OrderItem>) jdbcTemplate.query(sql, new OrderItemRowMapper(),orderId);
	}

}
