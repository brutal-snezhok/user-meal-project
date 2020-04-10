package com.tsyrulik.topjava.repository.jpa;

import com.tsyrulik.topjava.model.Meal;
import com.tsyrulik.topjava.repository.MealRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepository implements MealRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            em.persist(meal);
            return meal;
        } else {
            return em.merge(meal);
        }
    }

    @Override
    public boolean delete(int id, int userId) {
        return em.createNamedQuery(Meal.DELETE_MEAL, Meal.class).getResultList().isEmpty();
    }

    @Override
    public Meal get(int id, int userId) {
        return em.find(Meal.class, id);
    }

    @Override
    public List<Meal> getAll(int userId) {
       return em.createNamedQuery(Meal.ALL_MEAL, Meal.class).getResultList();
    }

    @Override
    public List<Meal> getBetweenHalfOpen(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}
