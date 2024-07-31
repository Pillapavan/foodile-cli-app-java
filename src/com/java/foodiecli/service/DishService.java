package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.DishAlreadyExistsException;
import com.java.foodiecli.exceptions.DishNotFoundException;
import com.java.foodiecli.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    public Dish save(Dish dish) throws DishAlreadyExistsException;
    public List<Dish> getAllDishes();
    public Dish getDishById(String id) throws DishNotFoundException;
    public Dish updateDish(Dish dish) throws DishNotFoundException;
    public void deleteDish(String Id) throws DishNotFoundException;
}
