package com.tsyrulik.topjava.service.datajpa;

import com.tsyrulik.topjava.UserTestData;
import com.tsyrulik.topjava.model.Meal;
import com.tsyrulik.topjava.service.AbstractMealServiceTest;
import com.tsyrulik.topjava.util.exception.NotFoundExceptionCustom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static com.tsyrulik.topjava.MealTestData.*;
import static com.tsyrulik.topjava.Profiles.DATAJPA;
import static com.tsyrulik.topjava.UserTestData.ADMIN_ID;

@ActiveProfiles(DATAJPA)
class DataJpaMealServiceTest extends AbstractMealServiceTest {

    @Test
    void getWithUser() throws Exception {
        Meal adminMeal = service.getWithUser(ADMIN_MEAL_ID, ADMIN_ID);
        MEAL_MATCHER.assertMatch(adminMeal, ADMIN_MEAL1);
        UserTestData.USER_MATCHER.assertMatch(adminMeal.getUser(), UserTestData.ADMIN);
    }

    @Test
    void getWithUserNotFound() throws Exception {
        Assertions.assertThrows(NotFoundExceptionCustom.class,
                () -> service.getWithUser(1, ADMIN_ID));
    }
}
