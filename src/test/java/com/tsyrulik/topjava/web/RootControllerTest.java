package com.tsyrulik.topjava.web;

import com.tsyrulik.topjava.model.User;
import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.tsyrulik.topjava.MealTestData.MEALS;
import static com.tsyrulik.topjava.UserTestData.*;
import static com.tsyrulik.topjava.util.MealsUtil.getTos;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class RootControllerTest extends AbstractControllerTest {

    @Test
    void getUsers() throws Exception {
        perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("users"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/users.jsp"))
                .andExpect(model().attribute("users",
                        new AssertionMatcher<List<User>>() {
                            @Override
                            public void assertion(List<User> actual) throws AssertionError {
                                USER_MATCHER.assertMatch(actual, ADMIN, USER);
                            }
                        }
                ));
    }

    @Test
    void getMeals() throws Exception {
        perform(get("/meals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("meals"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/meals.jsp"))
                .andExpect(model().attribute("meals", getTos(MEALS, SecurityUtil.authUserCaloriesPerDay())));
    }
}
