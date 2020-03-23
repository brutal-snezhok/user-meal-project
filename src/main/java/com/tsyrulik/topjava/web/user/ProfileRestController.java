package com.tsyrulik.topjava.web.user;

import com.tsyrulik.topjava.model.User;

import static com.tsyrulik.topjava.web.SecurityUtil.authUserId;

public class ProfileRestController extends AbstractUserController {

    public User get() {
        return super.get(authUserId());
    }

    public void delete() {
        super.delete(authUserId());
    }

    public void update(User user) {
        super.update(user, authUserId());
    }
}
