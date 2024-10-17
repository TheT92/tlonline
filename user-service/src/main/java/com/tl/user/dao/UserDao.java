package com.tl.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tl.user.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    
}
