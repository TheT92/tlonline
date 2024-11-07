package com.tl.goods.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.tl.common.utils.ApiResponse;
import com.tl.goods.dao.GoodsDao;
import com.tl.goods.entity.GoodsEntity;
import com.tl.goods.model.Goods;

@Service
public class GoodsService {
    @Autowired
    GoodsDao goodsDao;

    public ApiResponse<List<Goods>> getHomepageGoods() {
        try {
            List<Goods> list = goodsDao.findAll().stream().map(a -> entityToModel(a)).collect(Collectors.toList());
            return ApiResponse.success(list);
        } catch(Exception e) {
            return ApiResponse.error(HttpStatus.EXPECTATION_FAILED.value());
        }
    }

    private GoodsEntity modelToEntity(Goods goods) {
        return new GoodsEntity(goods.getId(), goods.getUuid(), goods.getName(), goods.getDesc(), goods.getState(), goods.getDelFlag());
    }

    private Goods entityToModel(GoodsEntity goodsEntity) {
        return new Goods(goodsEntity.getId(), goodsEntity.getUuid(), goodsEntity.getName(), goodsEntity.getDesc(), goodsEntity.getState(), goodsEntity.getDelFlag());
    }
}
