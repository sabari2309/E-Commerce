package com.avitam.application.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.avitam.application.dao.AddressDao;
import com.avitam.application.model.Address;
import com.avitam.application.rowmapper.AddressRowMapper;

public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
    
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Address> getAddressById(int user_id) {
		String sql="select * from address where user_id=?";
		return (List<Address>) jdbcTemplate.query(sql,new AddressRowMapper(),user_id);
	}

	@Override
	public boolean addAddress(Address address, int user_id) {
		String sql="insert into address (user_id,name,phone,address_line,city,state,pincode) values (?,?,?,?,?,?,?)";
		int rows=jdbcTemplate.update(sql,user_id,address.getName(),address.getPhone(),address.getAddress_line(),address.getCity(),address.getState(),address.getPincode());
		if(rows==0) {
			return false;
		}
		return true;
	}

	@Override
	public Address getByAddressId(int addressId) {
		String sql="select * from address where address_id=?";
		
		return (Address) jdbcTemplate.queryForObject(sql, new AddressRowMapper(),addressId);
	}

	
	

}
