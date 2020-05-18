package com.tsyrulik.topjava.service.jpa;

import com.tsyrulik.topjava.service.AbstractUserServiceTest;
import org.springframework.test.context.ActiveProfiles;

import static com.tsyrulik.topjava.Profiles.JPA;

@ActiveProfiles(JPA)
public class JpaUserServiceTest extends AbstractUserServiceTest {
}
