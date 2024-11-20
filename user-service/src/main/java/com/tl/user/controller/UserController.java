package com.tl.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tl.common.utils.ApiResponse;
import com.tl.user.model.User;
import com.tl.user.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<String>> signUp(@RequestBody User user) {
        ApiResponse<String> response = userService.signUp(user);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody User user) {
        ApiResponse<String> response = userService.login(user);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/userInfo")
    public ResponseEntity<ApiResponse<User>> getUserInfoByToken(@RequestHeader("X-User-ID") String userId ) {
        ApiResponse<User> response = userService.getUserInfo(userId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/userInfo/{id}")
    public ResponseEntity<ApiResponse<User>> getUserInfo(@PathVariable String id) {
        ApiResponse<User> response = userService.getUserInfo(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}
