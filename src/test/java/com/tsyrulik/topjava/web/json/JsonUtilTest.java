package com.tsyrulik.topjava.web.json;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.tsyrulik.topjava.View;
import com.tsyrulik.topjava.model.Meal;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.tsyrulik.topjava.MealTestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

class JsonUtilTest {

    @Test
    void readWriteValue() throws Exception {
        String json = JsonUtil.writeValue(ADMIN_MEAL1);
        System.out.println(json);
        Meal meal = JsonUtil.readValue(json, Meal.class);
        MEAL_MATCHER.assertMatch(meal, ADMIN_MEAL1);
    }

    @Test
    void readWriteValues() throws Exception {
        String json = JsonUtil.writeValue(MEALS);
        System.out.println(json);
        List<Meal> meals = JsonUtil.readValues(json, Meal.class);
        MEAL_MATCHER.assertMatch(meals, MEALS);
    }

    @Test
    public void writeWithView() throws Exception {
        ObjectWriter uiWriter = JacksonObjectMapper.getMapper().writerWithView(View.JsonUI.class);
        String json = JsonUtil.writeValue(ADMIN_MEAL1, uiWriter);
        System.out.println(json);
        assertThat(json, containsString("dateTimeUI"));
    }
}
