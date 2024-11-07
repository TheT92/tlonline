package com.tl.user.entity;

import java.util.UUID;

public class UserFactory {
    public static void setDefaultFields(UserEntity user) {
        if(user.getUuid() == null) {
            user.setUuid(UUID.randomUUID());
        }
        user.setDelFlag(0);
    }
}
