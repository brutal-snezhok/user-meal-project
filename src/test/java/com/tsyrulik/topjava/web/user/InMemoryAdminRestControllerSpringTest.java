package com.tsyrulik.topjava.web.user;

import com.tsyrulik.topjava.repository.inmemory.InMemoryUserRepository;
import com.tsyrulik.topjava.util.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static com.tsyrulik.topjava.UserTestData.USER_ID;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/inmemory.xml"})
@RunWith(SpringRunner.class)
public class InMemoryAdminRestControllerSpringTest {

    @Autowired
    private AdminRestController controller;

    @Autowired
    private InMemoryUserRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.init();
    }

    @Test
    public void delete() throws Exception {
        controller.delete(USER_ID);
        Assert.assertNull(repository.get(USER_ID));
    }

    @Test
    public void deleteNotFound() throws Exception {
        Assert.assertThrows(NotFoundException.class, () -> controller.delete(10));
    }
}
