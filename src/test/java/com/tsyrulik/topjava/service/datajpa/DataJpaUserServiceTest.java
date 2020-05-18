package com.tsyrulik.topjava.service.datajpa;

import com.tsyrulik.topjava.MealTestData;
import com.tsyrulik.topjava.model.User;
import com.tsyrulik.topjava.service.AbstractUserServiceTest;
import com.tsyrulik.topjava.util.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import static com.tsyrulik.topjava.Profiles.DATAJPA;
import static com.tsyrulik.topjava.UserTestData.*;

@ActiveProfiles(DATAJPA)
public class DataJpaUserServiceTest extends AbstractUserServiceTest {

    @Test
    public void getWithMeals() throws Exception {
        User user = service.getWithMeals(USER_ID);
        USER_MATCHER.assertMatch(user, USER);
        MealTestData.MEAL_MATCHER.assertMatch(user.getMeals(), MealTestData.MEALS);
    }

    @Test
    public void getWithMealsNotFound() throws Exception {
        Assert.assertThrows(NotFoundException.class,
                () -> service.getWithMeals(1));
    }
}
