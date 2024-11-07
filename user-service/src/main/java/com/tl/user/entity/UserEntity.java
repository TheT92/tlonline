package com.tl.user.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data 注解是 Lombok 库中的一个注解，它用于自动生成 Java 类中的常见方法，包括 getter、
// setter、toString()、equals()、hashCode() 和 constructor 方法
// @NoArgsConstructor表示为该类添加一个默认无参构造方法

// @Entity 标记一个类为 JPA 实体，表示该类的实例可以映射到数据库中的一条记录。只要有 @Entity 注解，
// JPA 就会自动在数据库中创建对应的表，表名通常为类名（符合数据库的命名规则）。

// @Table 是可选的，它提供了更多自定义选项。可以用它指定表的名称、模式（schema）、以及在多列上创建唯一约束等
@Data
@NoArgsConstructor
@Entity
@Table(name="user")
public class UserEntity {
    // @Id注释用来标识主键
    // @GeneratedValue 使用自增ID，保证id索引的效率
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // uuid作为展示ID，保证唯一性和安全性
    @Column(columnDefinition = "BINARY(16)")
    // 如果要考虑兼容性可以使用String存储UUID，但是占空间更大，且语意不明
    private UUID uuid;
    // 添加唯一约束，侧面减轻并发
    @Column(unique = true)
    private String account;
    private String password;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(name="del_flag")
    private Integer delFlag; // 0 not deleted, 1 deleted

    public UserEntity(Integer id, UUID uuid, String account, String password, String firstName, String lastName, String email, Integer delFlag) {
        this.id = id;
        this.uuid = uuid;
        this.account = account;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.delFlag = delFlag;
    }
}
