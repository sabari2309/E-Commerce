package com.avitam.application.daoimpl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.avitam.application.dao.OrderDao;
import com.avitam.application.model.Order;
import com.avitam.application.model.OrderItem;
import com.avitam.application.rowmapper.OrderItemRowMapper;
import com.avitam.application.rowmapper.OrderRowMapper;


public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int createOrder(int user_id, int addressId, double total) {
		String sql="insert into orders (user_id,address_id,total_amount) values (?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps =
                con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user_id);
            ps.setInt(2, addressId);
            ps.setDouble(3, total);
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
	}

	@Override
	public List<Order> getOrderByUser(int user_id) {
		String sql="select * from orders where user_id=?";
		return (List<Order>) jdbcTemplate.query(sql, new OrderRowMapper(),user_id);
	}

	@Override
	public List<OrderItem> getOrderByOrderId(int orderId) {
		String sql="select * from order_items where order_id=?";
		return (List<OrderItem>) jdbcTemplate.query(sql, new OrderItemRowMapper(),orderId);
	}

	@Override
	public Order getDetailsByOrderId(int orderId) {
		String sql="select * from orders where order_id=?";
		
		return (Order) jdbcTemplate.queryForObject(sql, new OrderRowMapper(),orderId);
	}

}
