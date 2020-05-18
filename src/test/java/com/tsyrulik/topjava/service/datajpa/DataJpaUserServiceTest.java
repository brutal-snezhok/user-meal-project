package com.tsyrulik.topjava.service.datajpa;

import com.tsyrulik.topjava.service.AbstractUserServiceTest;
import org.springframework.test.context.ActiveProfiles;

import static com.tsyrulik.topjava.Profiles.DATAJPA;

@ActiveProfiles(DATAJPA)
public class DataJpaUserServiceTest extends AbstractUserServiceTest {
}
