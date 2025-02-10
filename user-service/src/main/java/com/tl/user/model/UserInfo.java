package com.tl.user.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfo {
    // 将uuid作为id给用户展示
    private String uuid;
    private String account;
    private String firstName;
    private String lastName;
    private String email;

    public UserInfo(String uuid, String account, String firstName, String lastName, String email) {
        this.uuid = uuid;
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
