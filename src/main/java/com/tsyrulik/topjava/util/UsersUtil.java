package com.tsyrulik.topjava.util;

import com.tsyrulik.topjava.model.Role;
import com.tsyrulik.topjava.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsersUtil {
    private static Set<Role> userRole = new HashSet<>();

    static {
        userRole.add(Role.ROLE_USER);
    }

    public static final List<User> USERS = Arrays.asList(
            new User(1, "User1", "user1@gmail.com", "password1", 121, true, userRole),
            new User(2, "User2", "user2@gmail.com", "password2", 122, true, userRole),
            new User(3, "User3", "user3@gmail.com", "password3", 123, false, userRole),
            new User(4, "User4", "user4@gmail.com", "password4", 124, false, userRole),
            new User(5, "User5", "user5@gmail.com", "password5", 125, true, userRole)
    );
}
