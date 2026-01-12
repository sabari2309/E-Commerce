package com.avitam.application.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avitam.application.model.SubCategory;

public class SubCategoryRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		SubCategory subCategory=new SubCategory();
		subCategory.setId(rs.getInt(1));
		subCategory.setName(rs.getString(2));
		subCategory.setCategory_id(rs.getInt(3));
		return subCategory;
	}

}
