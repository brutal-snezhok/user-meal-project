package com.tsyrulik.topjava.web.user;

import com.tsyrulik.topjava.UserTestData;
import com.tsyrulik.topjava.model.User;
import com.tsyrulik.topjava.repository.inmemory.InMemoryUserRepository;
import com.tsyrulik.topjava.util.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static com.tsyrulik.topjava.UserTestData.ADMIN;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringRunner.class)
@Ignore
public class InMemoryAdminRestControllerSpringTest {

    @Autowired
    private AdminRestController controller;

    @Autowired
    @Qualifier("inMemoryUserRep")
    private InMemoryUserRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.init();
    }

    @Test
    public void delete() throws Exception {
        controller.delete(UserTestData.USER_ID);
        Collection<User> users = controller.getAll();
        Assert.assertEquals(1, users.size());
        Assert.assertEquals(ADMIN, users.iterator().next());
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        controller.delete(10);
    }
}
