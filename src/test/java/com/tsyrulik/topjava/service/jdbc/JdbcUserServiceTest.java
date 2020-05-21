package com.tsyrulik.topjava.service.jdbc;

import com.tsyrulik.topjava.service.AbstractUserServiceTest;
import org.junit.jupiter.api.Disabled;
import org.springframework.test.context.ActiveProfiles;

import static com.tsyrulik.topjava.Profiles.JDBC;

@ActiveProfiles(JDBC)
@Disabled
class JdbcUserServiceTest extends AbstractUserServiceTest {
}
