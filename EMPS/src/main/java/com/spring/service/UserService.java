package com.spring.service;

import com.spring.dto.UpdateUserDto;
import com.spring.model.UserEntity;
import com.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UpdateUserDto updateUser(Long userId, UpdateUserDto updateUserDto) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User id not found"));
        
        if (updateUserDto.getStaffName() != null) {
            userEntity.setStaffName(updateUserDto.getStaffName());
        }
        if (updateUserDto.getEmail() != null) {
            userEntity.setEmail(updateUserDto.getEmail());
        }
        if (updateUserDto.getPhoneNo() != null) {
            userEntity.setPhoneNo(updateUserDto.getPhoneNo());
        }
        if (updateUserDto.getContactAddress() != null) {
            userEntity.setContactAddress(updateUserDto.getContactAddress());
        }
        
        UserEntity updatedUser = userRepository.save(userEntity);
        
        return new UpdateUserDto(
                updatedUser.getStaffName(),
                updatedUser.getEmail(),
                updatedUser.getPhoneNo(),
                updatedUser.getContactAddress()
        );
    }

    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}