package com.avitam.application.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.avitam.application.dao.CategoryDao;
import com.avitam.application.model.Category;
import com.avitam.application.rowmapper.CategoryRowMapper;

public class CategoryDaoImpl implements CategoryDao{
	
	public CategoryDaoImpl() {
		System.out.println("CategoryDao Bean created");
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<Category> getAllCategories() {
		String sql = "SELECT id, name, icon FROM categories";

        return jdbcTemplate.query(sql,new CategoryRowMapper());
	}


	@Override
	public Category getCategoryById(int categoryId) {
		String sql="SELECT * FROM categories where id =?";
	    return (Category) jdbcTemplate.queryForObject(sql, new CategoryRowMapper(),categoryId);
	}


	@Override
	public List<Category> getCategoriesById(int categoryId) {
		String sql="SELECT * FROM sub_category where category_id=?";
		return (List<Category>) jdbcTemplate.query(sql, new CategoryRowMapper(),categoryId);
	}

}
