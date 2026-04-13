package com.spring.controller;

import com.spring.dto.UpdateUserDto;
import com.spring.model.UserEntity;
import com.spring.service.AuthService;
import com.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthService authService;
    
    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/me")
    public ResponseEntity<UserEntity> getCurrentUser() {
        return ResponseEntity.ok(authService.getCurrentUser());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UpdateUserDto> updateUser(@PathVariable Long userId, @RequestBody UpdateUserDto userDto){
        return ResponseEntity.ok(userService.updateUser(userId, userDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}