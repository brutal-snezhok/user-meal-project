package com.tsyrulik.topjava.web.user;

import com.tsyrulik.topjava.repository.inmemory.InMemoryUserRepository;
import com.tsyrulik.topjava.util.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static com.tsyrulik.topjava.UserTestData.USER_ID;

@SpringJUnitConfig(locations = {"classpath:spring/inmemory.xml"})
class InMemoryAdminRestControllerSpringTest {

    @Autowired
    private AdminRestController controller;

    @Autowired
    private InMemoryUserRepository repository;

    @BeforeEach
    void setUp() throws Exception {
        repository.init();
    }

    @Test
    void delete() throws Exception {
        controller.delete(USER_ID);
        Assertions.assertNull(repository.get(USER_ID));
    }

    @Test
    void deleteNotFound() throws Exception {
        Assertions.assertThrows(NotFoundException.class, () -> controller.delete(10));
    }
}
