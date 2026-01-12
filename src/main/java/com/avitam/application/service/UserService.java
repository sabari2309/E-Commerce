package com.avitam.application.service;

import com.avitam.application.model.User;

public interface UserService {
    boolean registerUser(User user);

	User loginUser(String email, String password);
}