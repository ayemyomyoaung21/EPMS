package com.spring.service;

import com.spring.security.model.UpdateUserDto;
import com.spring.security.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    UpdateUserDto updateUser(Integer userId,UpdateUserDto updateUserDto);
    User getUserById(Integer userId);
}
