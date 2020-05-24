package com.tsyrulik.topjava.util;

import com.tsyrulik.topjava.model.Role;
import com.tsyrulik.topjava.model.User;
import com.tsyrulik.topjava.to.UserTo;

public class UserUtil {

    public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getName(), userTo.getEmail().toLowerCase(), userTo.getPassword(), Role.ROLE_USER);
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        return user;
    }
}
