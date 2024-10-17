package com.tl.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tl.user.bean.User;
import com.tl.user.bean.UserFactory;
import com.tl.user.dao.UserDao;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 注册接口
     * @param user
     * @return
     */
    public ApiResponse<String> signUp(User user) {
        try {
            UserFactory.setDefaultFields(user);
            userDao.save(user);
            return ApiResponse.error(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
        } catch (Exception e) {
            return ApiResponse.error(HttpStatus.EXPECTATION_FAILED.value(), "Unauthorized");
        }
    }

    /**
     * 登录接口
     * @param user
     * @return
     */
    public ApiResponse<String> login(User user) {
        try {
            UserFactory.setDefaultFields(user);
            userDao.save(user);
            return ApiResponse.error(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
        } catch (Exception e) {
            return ApiResponse.error(HttpStatus.EXPECTATION_FAILED.value(), "Unauthorized");
        }
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    public ApiResponse<User> getUserInfo(String id) {
        try {
            User user = new User();
            user.setFirstName("Jack");
            return ApiResponse.success(user);
        } catch (Exception e) {
            return ApiResponse.error(HttpStatus.EXPECTATION_FAILED.value());
        }
    }
}
