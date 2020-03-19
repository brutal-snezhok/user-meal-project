package com.tsyrulik.topjava.web;

import com.tsyrulik.topjava.model.MealTo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.tsyrulik.topjava.util.MealsUtil.getMealTos;

public class MealServlet extends HttpServlet {

    private static List<MealTo> mealTos = new ArrayList<>();

    static {
        mealTos = getMealTos();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("meals", mealTos);

        req.getRequestDispatcher("/meals.jsp").forward(req, resp);
    }
}
