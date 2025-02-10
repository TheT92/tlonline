package com.tl.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tl.common.utils.ApiResponse;
import com.tl.goods.model.Goods;
import com.tl.goods.service.GoodsService;


@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping
    public String getGoodsItem() {
        return "Hello, Goods!";
    }

    @GetMapping("/home")
    public ResponseEntity<ApiResponse<List<Goods>>> getHomepageGoods() {
        ApiResponse<List<Goods>> response = goodsService.getHomepageGoods();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/detail/{uuid}")
    public ResponseEntity<ApiResponse<Goods>> getGoodsDetailByUuid(@PathVariable("uuid") String uuid) {
        ApiResponse<Goods> response = goodsService.getGoodsDetailByUuid(uuid);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
    
}
