package com.tsyrulik.topjava.service;

import com.tsyrulik.topjava.model.Meal;
import com.tsyrulik.topjava.repository.MealRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.tsyrulik.topjava.util.DateTimeUtil.getEndExclusive;
import static com.tsyrulik.topjava.util.DateTimeUtil.getStartInclusive;
import static com.tsyrulik.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal get(int id, int userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public List<Meal> getBetweenHalfOpen(@Nullable LocalDate startDate, @Nullable LocalDate endDate, int userId) {
        return repository.getBetweenHalfOpen(getStartInclusive(startDate), getEndExclusive(endDate), userId);
    }

    public List<Meal> getAll(int userId) {
        return repository.getAll(userId);
    }

    public void update(Meal meal, int userId) {
        checkNotFoundWithId(repository.save(meal, userId), meal.getId());
    }

    public Meal create(Meal meal, int userId) {
        return repository.save(meal, userId);
    }
}
