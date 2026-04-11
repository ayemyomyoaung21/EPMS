package com.spring.service.impl;

import com.spring.security.model.UpdateUserDto;
import com.spring.security.model.User;
import com.spring.security.repository.UserRepository;
import com.spring.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UpdateUserDto updateUser(Integer userId,UpdateUserDto updateUserDto) {
        User user =userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User id not found"));
        user.setName(updateUserDto.getName());
        user.setEmail(updateUserDto.getEmail());
        User updateUser = userRepository.save(user);
        return new UpdateUserDto(
                updateUserDto.getName(),
                updateUserDto.getEmail()
        );
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }
}
