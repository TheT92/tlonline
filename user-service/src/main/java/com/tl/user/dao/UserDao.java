package com.tl.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tl.user.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    
}
