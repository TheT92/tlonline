package com.tl.goods.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tl.goods.entity.GoodsEntity;

@Repository
public interface GoodsDao extends JpaRepository<GoodsEntity, Integer> {
    public Optional<GoodsEntity> findByUuid(UUID uuid);
}
