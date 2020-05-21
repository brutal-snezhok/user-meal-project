package com.tsyrulik.topjava.service.jdbc;

import com.tsyrulik.topjava.service.AbstractUserServiceTest;
import org.springframework.test.context.ActiveProfiles;

import static com.tsyrulik.topjava.Profiles.JDBC;

@ActiveProfiles(JDBC)
class JdbcUserServiceTest extends AbstractUserServiceTest {
}
