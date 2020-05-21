package com.tsyrulik.topjava.service.datajpa;

import com.tsyrulik.topjava.MealTestData;
import com.tsyrulik.topjava.model.User;
import com.tsyrulik.topjava.service.AbstractUserServiceTest;
import com.tsyrulik.topjava.util.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static com.tsyrulik.topjava.Profiles.DATAJPA;
import static com.tsyrulik.topjava.UserTestData.*;

@ActiveProfiles(DATAJPA)
class DataJpaUserServiceTest extends AbstractUserServiceTest {

    @Test
    void getWithMeals() throws Exception {
        User admin = service.getWithMeals(ADMIN_ID);
        USER_MATCHER.assertMatch(admin, ADMIN);
        MealTestData.MEAL_MATCHER.assertMatch(admin.getMeals(), MealTestData.ADMIN_MEAL2, MealTestData.ADMIN_MEAL1);
    }

    @Test
    void getWithMealsNotFound() throws Exception {
        Assertions.assertThrows(NotFoundException.class,
                () -> service.getWithMeals(1));
    }
}
