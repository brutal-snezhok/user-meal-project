package com.tsyrulik.topjava.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tsyrulik.topjava.model.User;
import com.tsyrulik.topjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.tsyrulik.topjava.util.ValidationUtil.assureIdConsistent;
import static com.tsyrulik.topjava.util.ValidationUtil.checkNew;

public abstract class AbstractUserController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return service.create(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        assureIdConsistent(user, id);
        service.update(user);
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }
}
