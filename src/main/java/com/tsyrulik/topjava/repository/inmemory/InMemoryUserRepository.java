package com.tsyrulik.topjava.repository.inmemory;

import com.tsyrulik.topjava.model.User;
import com.tsyrulik.topjava.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.tsyrulik.topjava.UserTestData.*;

@Repository
public class InMemoryUserRepository extends InMemoryBaseRepository<User> implements UserRepository {

    public void init() {
        map.clear();
        map.put(USER_ID, USER);
        map.put(ADMIN_ID, ADMIN);
    }

    @Override
    public List<User> getAll() {
        return getCollection().stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        Objects.requireNonNull(email, "email must not be null");
        return getCollection().stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }
}
