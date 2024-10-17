package com.tl.user.bean;

import java.util.UUID;

public class UserFactory {
    public static void setDefaultFields(User user) {
        if(user.getUuid() == null) {
            user.setUuid(UUID.randomUUID());
        }
        user.setDelFlag(0);
    }
}
