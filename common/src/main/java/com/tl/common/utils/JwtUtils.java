package com.tl.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtils {

    // 生成一个随机密钥（推荐在项目启动时加载固定密钥）
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("QWERTYASDFGHZXCVBNMPOIULKJ1236547890abcdefghijklmnopqrstuvwxyz!@#$%^&*()".getBytes(StandardCharsets.UTF_8));

    // Token 有效期：12小时
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000;

    /**
     * 生成 JWT Token
     */
    public static String generateToken(String userId) {
        return Jwts.builder()
                .setSubject(userId) // 设置主题，一般是用户 ID
                .setIssuedAt(new Date()) // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 过期时间
                .signWith(SECRET_KEY) // 使用密钥签名
                .compact();
    }

    /**
     * 验证并解析 Token
     */
    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // 设置用于验证的密钥
                .build()
                .parseClaimsJws(token) // 解析 Token
                .getBody(); // 获取 Claims
    }

    /**
     * 从 Token 中获取用户 ID
     */
    public static String getUserIdFromToken(String token) {
        Claims claims = validateToken(token);
        return claims.getSubject();
    }
}

