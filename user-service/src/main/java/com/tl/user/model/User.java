package com.tl.user.model;

import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Integer id;
    private UUID uuid;
    private String account;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer delFlag; // 0 not deleted, 1 deleted

    public User(Integer id, UUID uuid, String account, String password, String firstName, String lastName, String email, Integer delFlag) {
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
