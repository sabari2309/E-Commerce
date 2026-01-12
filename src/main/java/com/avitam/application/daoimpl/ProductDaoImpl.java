package com.avitam.application.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.avitam.application.dao.ProductDao;
import com.avitam.application.model.Product;
import com.avitam.application.rowmapper.ProductRowMapper;

public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProductDaoImpl() {
		System.out.println("productDao Bean created");
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Product> getProductsByCategory(int categoryId) {
		String sql="select * from product where sub_category_id=?";
		try {
			return (List<Product>) jdbcTemplate.query(sql, new ProductRowMapper(),categoryId);
		}catch (EmptyResultDataAccessException e) {
            return null; 
        }
	}
	@Override
	public Product getProductById(int productId) {
		String sql="SELECT * FROM product where id=?";
		return (Product) jdbcTemplate.queryForObject(sql, new ProductRowMapper(), productId);
	}

}
