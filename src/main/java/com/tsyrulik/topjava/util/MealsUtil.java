package com.tsyrulik.topjava.util;

import com.tsyrulik.topjava.model.Meal;
import com.tsyrulik.topjava.to.MealTo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MealsUtil {
    public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    private MealsUtil() {
    }

    public static List<MealTo> getTos(Collection<Meal> meals, int caloriesPerDay) {
        return filteredByStreams(meals, caloriesPerDay, meal -> true);
    }

    public static List<MealTo> getFilteredTos(Collection<Meal> meals, int caloriesPerDay, LocalTime startTime, LocalTime endTime) {
        return filteredByStreams(meals, caloriesPerDay, meal -> Util.isBetweenHalfOpen(meal.getDateTime().toLocalTime(), startTime, endTime));

    }

    public static List<MealTo> filteredByStreams(Collection<Meal> meals, int caloriesPerDay, Predicate<Meal> filter) {
        Map<LocalDate, Integer> dateCaloriesMap = meals.stream().collect(Collectors.groupingBy(meal -> meal.getDateTime().toLocalDate(), Collectors.summingInt(Meal::getCalories)));

        return meals
                .stream()
                .filter(filter)
                .map(userMeal -> createTo(userMeal, 
                                          dateCaloriesMap.get(userMeal.getDateTime().toLocalDate()) <= caloriesPerDay))
                .collect(Collectors.toList());
    }

    private static MealTo createTo(Meal meal, boolean excess) {
        return new MealTo(meal.getId(), meal.getDateTime(), meal.getDescription(), meal.getCalories(), excess);
    }
}
