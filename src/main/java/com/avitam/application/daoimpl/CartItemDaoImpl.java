package com.avitam.application.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.avitam.application.dao.CartItemDao;
import com.avitam.application.model.CartItem;
import com.avitam.application.rowmapper.CartItemOnlyRowMapper;
import com.avitam.application.rowmapper.CartItemRowMapper;

public class CartItemDaoImpl implements CartItemDao {
 
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public CartItemDaoImpl() {
		System.out.println("cartitemdao bean created");
	}
	
	@Override
	public CartItem getCartItemByProductAndId(int cart_id, int product_id) {
		String sql="select * from cart_items where cart_id=? and product_id=?";
		try {
			return (CartItem) jdbcTemplate.queryForObject(sql, new CartItemOnlyRowMapper(),cart_id,product_id);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int createAndAddToCart(int cart_id, int product_id, int quantity) {
		String sql="insert into cart_items(cart_id,product_id,quantity)values(?,?,?)";
		return jdbcTemplate.update(sql, cart_id,product_id,quantity);
	}

	@Override
	public int updateCartIfExists(int cart_id, int product_id, int quantity) {
		String sql="update cart_items set quantity=quantity + ? where cart_id =? and product_id=?";
		
		return jdbcTemplate.update(sql,quantity,cart_id,product_id);
	}

	@Override
	public List<CartItem> getItemsByCartId(int cart_id) {
		String sql="SELECT ci.cart_item_id,ci.cart_id,ci.product_id,ci.quantity,p.id,p.name,p.price,p.image FROM cart_items ci JOIN product p ON ci.product_id = p.id WHERE ci.cart_id =?";
		
		return (List<CartItem>) jdbcTemplate.query(sql,new CartItemRowMapper(),cart_id);
	}

	@Override
	public CartItem getCartItemById(int cartItemId) {
		String sql="SELECT ci.cart_item_id,ci.cart_id,ci.product_id,ci.quantity,p.id,p.name,p.price,p.image FROM cart_items ci JOIN product p ON ci.product_id = p.id WHERE ci.cart_item_id =?";
		
		return (CartItem) jdbcTemplate.queryForObject(sql,new CartItemRowMapper(),cartItemId);
	}

	@Override
	public void updateCart(int cartItemId, int quantity) {
		String sql="update cart_items set quantity=? where cart_item_id=?";
		jdbcTemplate.update(sql,quantity,cartItemId);
		
	}

	@Override
	public void removeItem(int cartItemId) {
		String sql="delete from cart_items where cart_item_id=?";
		jdbcTemplate.update(sql,cartItemId);
		
	}

}
