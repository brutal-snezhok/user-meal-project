package com.tsyrulik.topjava.repository;

import com.tsyrulik.topjava.model.User;

import java.util.Collection;

public interface UserRepository {
    // null if not found, when updated
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    Collection<User> getAll();
}
