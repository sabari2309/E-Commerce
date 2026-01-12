package com.avitam.application.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avitam.application.model.Category;

public class CategoryRowMapper implements RowMapper {

	
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category=new Category();
		category.setId(rs.getInt(1));
		category.setName(rs.getString(2));
		category.setIcon(rs.getString(3));
		return category;
		
	}
	

}
