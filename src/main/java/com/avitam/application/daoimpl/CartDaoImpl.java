package com.avitam.application.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.avitam.application.dao.CartDao;
import com.avitam.application.model.Cart;
import com.avitam.application.rowmapper.CartRowMapper;

public class CartDaoImpl implements CartDao{
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CartDaoImpl() {
		System.out.println("cartdao bean created");
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Cart fetchCartByUserId(int user_id) {
		String sql="select * from cart where user_id=?";
		Cart cart=new Cart();
		try {
		cart=(Cart) jdbcTemplate.queryForObject(sql, new CartRowMapper(),user_id);
		}catch (EmptyResultDataAccessException e) {
            return null; 
        }
		return cart;
	}

	@Override
	public Cart createCartAndReturn(int user_id) {
		String sql="insert into cart (user_id) values (?)";
		jdbcTemplate.update(sql,user_id);
		String sql1="select * from cart where user_id=?";
		Cart cart=(Cart) jdbcTemplate.queryForObject(sql1, new CartRowMapper(),user_id);
		return cart;
	}

}
