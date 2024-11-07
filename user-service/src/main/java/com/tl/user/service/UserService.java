package com.tl.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tl.user.model.User;
import com.tl.user.dao.UserDao;
import com.tl.user.entity.UserEntity;
import com.tl.user.entity.UserFactory;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 注册接口
     * TODO: 在用户请求注册时，先将数据写入缓存（如 Redis），然后异步将数据批量同步到数据库。
     * 这种方式可以将写入压力从数据库转移到缓存上，大幅提高注册响应速度，特别适合在并发较高的场景。
     * @param user
     * @return
     */
    public ApiResponse<String> signUp(User user) {
        try {
            UserEntity userEntity = this.modelToEntity(user);
            UserFactory.setDefaultFields(userEntity);
            userDao.save(userEntity);
            return ApiResponse.error(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
        } catch (Exception e) {
            return ApiResponse.error(HttpStatus.EXPECTATION_FAILED.value(), "Exception");
        }
    }

    /**
     * 登录接口
     * @param user
     * @return
     */
    public ApiResponse<String> login(User user) {
        try {
            UserEntity userEntity = this.modelToEntity(user);
            UserFactory.setDefaultFields(userEntity);
            userDao.save(userEntity);
            return ApiResponse.error(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
        } catch (Exception e) {
            return ApiResponse.error(HttpStatus.EXPECTATION_FAILED.value(), "Exception");
        }
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    public ApiResponse<User> getUserInfo(String id) {
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setFirstName("Jack");
            return ApiResponse.success(this.entityToModel(userEntity));
        } catch (Exception e) {
            return ApiResponse.error(HttpStatus.EXPECTATION_FAILED.value(), "Exception");
        }
    }

    private UserEntity modelToEntity(User user) {
        return new UserEntity(user.getId(), user.getUuid(), user.getAccount(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getDelFlag());
    }

    private User entityToModel(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUuid(), userEntity.getAccount(), userEntity.getPassword(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getDelFlag());
    }
}
