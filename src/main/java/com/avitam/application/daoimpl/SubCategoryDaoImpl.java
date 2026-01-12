package com.avitam.application.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.avitam.application.dao.SubCategoryDao;
import com.avitam.application.model.SubCategory;
import com.avitam.application.rowmapper.SubCategoryRowMapper;

public class SubCategoryDaoImpl implements SubCategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public SubCategoryDaoImpl() {
		System.out.println("SubCategoryDao Bean created");
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<SubCategory> getSubCategoryById(int category_id) {
		String sql="SELECT * FROM sub_category where category_id=?";
		return (List<SubCategory>) jdbcTemplate.query(sql, new SubCategoryRowMapper(),category_id);
	}

	@Override
	public SubCategory getSubCat(int sub_categoryId) {
		String sql="SELECT * FROM sub_category where id=?";
		return (SubCategory) jdbcTemplate.queryForObject(sql, new SubCategoryRowMapper(), sub_categoryId);
	}

}
