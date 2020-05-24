package com.tsyrulik.topjava.web;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.tsyrulik.topjava.MealTestData.MEALS;
import static com.tsyrulik.topjava.TestUtil.userAuth;
import static com.tsyrulik.topjava.UserTestData.ADMIN;
import static com.tsyrulik.topjava.util.MealsUtil.getTos;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Disabled
class RootControllerTest extends AbstractControllerTest {

    @Test
    void getUsers() throws Exception {
        perform(get("/users")
                .with(userAuth(ADMIN)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("users"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/users.jsp"));
    }

    @Test
    void unAuth() throws Exception {
        perform(get("/users"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
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
