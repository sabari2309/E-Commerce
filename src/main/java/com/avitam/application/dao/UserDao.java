package com.avitam.application.dao;

import java.util.List;

import com.avitam.application.model.User;

public interface UserDao {
    boolean saveUser(User user);

	List<User> getAllusers();

	User getUserByEmail(String email);
}