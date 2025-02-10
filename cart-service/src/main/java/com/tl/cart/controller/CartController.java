package com.tl.cart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @GetMapping
    public String test() {
        return "Hello Cart!";
    }

    // 添加到购物车
    // 从购物车删除
    // 从购物车选择指定商品生成订单并从购物车删除相应商品
    // 查询购物车内商品列表
}
