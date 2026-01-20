package com.avitam.application.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.avitam.application.model.Address;

public class AddressRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address address=new Address();
		address.setAddress_id(rs.getInt(1));
		address.setUser_id(rs.getInt(2));
		address.setName(rs.getString(3));
		address.setPhone(rs.getString(4));
		address.setAddress_line(rs.getString(5));
		address.setCity(rs.getString(6));
		address.setState(rs.getString(7));
		address.setPincode(rs.getString(8));
		return address;
	}

}
