package com.tl.user.bean;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    // @Id注释用来标识主键
    // @GeneratedValue 使用自增ID，保证id索引的效率
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // uuid作为展示ID，保证唯一性和安全性
    @Column(columnDefinition = "BINARY(16)")

    // 如果要考虑兼容性可以使用String存储UUID，但是占空间更大，且语意不明
    private UUID uuid;
    private String account;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer delFlag; // 0 not deleted, 1 deleted
}
