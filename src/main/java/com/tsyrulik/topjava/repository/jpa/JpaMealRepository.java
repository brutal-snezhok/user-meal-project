package com.tsyrulik.topjava.repository.jpa;

import com.tsyrulik.topjava.model.Meal;
import com.tsyrulik.topjava.repository.MealRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JpaMealRepository implements MealRepository {

    @Override
    public Meal save(Meal meal, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public Meal get(int id, int userId) {
        return null;
    }

    @Override
    public List<Meal> getAll(int userId) {
        return null;
    }

    @Override
    public List<Meal> getBetweenHalfOpen(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}
