package com.tl.goods.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tl.goods.entity.GoodsEntity;

@Repository
public interface GoodsDao extends JpaRepository<GoodsEntity, Integer> {
    
}
