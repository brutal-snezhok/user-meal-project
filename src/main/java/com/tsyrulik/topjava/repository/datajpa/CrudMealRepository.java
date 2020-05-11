package com.tsyrulik.topjava.repository.datajpa;

import com.tsyrulik.topjava.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
}
