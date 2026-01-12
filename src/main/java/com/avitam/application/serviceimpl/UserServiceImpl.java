package com.avitam.application.serviceimpl;

import com.avitam.application.dao.UserDao;
import com.avitam.application.model.User;
import com.avitam.application.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl bean created");
    }
    public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    
	public boolean registerUser(User user) {
		List<User> existingUser=userDao.getAllusers();
		for(User u:existingUser) {
			if(u.getEmail().equals(user.getEmail())) {
				return false;
			}
		}
        boolean saved=userDao.saveUser(user);
        if(saved) {
        	return true;
        }
        return false;
        	
    }
	@Override
	public User loginUser(String email, String password) {
		User user=userDao.getUserByEmail(email);
		if(user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
