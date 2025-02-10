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
import com.tl.user.model.UserInfo;
import com.tl.user.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // TODO： 邮箱校验、电话校验等放在后台服务进行
    // 收货地址管理

    // 后台服务和前台实体类怎么统一，三种做法
    // 创建公共模块（Common Module）：
    // 如果前台和后台服务共享大量的相同数据模型或实体类，并且业务逻辑之间有一定程度的交集，使用公共模块是最合适的。这种方式适用于数据结构一致且想要避免重复开发的项目。
    
    // 跨服务调用（API 调用）：
    // 如果前台和后台服务的业务逻辑差异较大，且它们的模型有较大不同，或者你希望保持服务间的完全解耦，使用跨服务调用更合适。尤其适合前后台服务之间的数据交换不频繁或者业务完全独立的场景。
    
    // 共享接口或公共服务：
    // 如果你希望多个服务遵循相同的数据结构接口，但具体的实现和业务逻辑是独立的，使用共享接口是合适的。适用于数据结构一致性需求较强的项目，但允许业务处理有所不同。

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
    public ResponseEntity<ApiResponse<UserInfo>> getUserInfoByToken(@RequestHeader("X-User-ID") String userId) {
        ApiResponse<UserInfo> response = userService.getUserInfo(userId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/userInfo/{id}")
    public ResponseEntity<ApiResponse<UserInfo>> getUserInfo(@PathVariable String id) {
        ApiResponse<UserInfo> response = userService.getUserInfo(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}
