package com.avitam.application.daoimpl;

import com.avitam.application.dao.UserDao;
import com.avitam.application.model.User;
import com.avitam.application.rowmapper.UserRowMapper;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
	
	public UserDaoImpl() {
        System.out.println("UserDaoImpl beans created");
    }
	
	private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	
    public boolean saveUser(User user) {
    	  String sql = "INSERT INTO users (first_name, last_name, email, password, mobile_number) VALUES (?, ?, ?, ?, ?)";
          
          int rows=jdbcTemplate.update(sql,
                  user.getFirstName(),
                  user.getLastName(),
                  user.getEmail(),
                  user.getPassword(),
                  user.getMobileNumber()
          );
          if(rows==0) {
        	  return false;
          }
          return true;
    }


	@Override
	public List<User> getAllusers() {
		String sql="SELECT * FROM users";
		return jdbcTemplate.query(sql,new UserRowMapper());
	}


	@Override
	public User getUserByEmail(String email) {
		String sql = "SELECT id, first_name, last_name, email, password, mobile_number " +
                "FROM users WHERE email = ?";

		try {
		    return  (User) jdbcTemplate.queryForObject(sql, new UserRowMapper(),email);
		}catch (EmptyResultDataAccessException e) {
            return null; 
        }
	}
}