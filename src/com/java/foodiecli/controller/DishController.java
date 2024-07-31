package com.java.foodiecli.controller;

import com.java.foodiecli.exceptions.DishAlreadyExistsException;
import com.java.foodiecli.exceptions.DishNotFoundException;
import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.model.Dish;
import com.java.foodiecli.service.DishServiceImpl;

import java.util.List;

public class DishController {
   private final DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = Factory.getDishService();
    }
    public Dish save(Dish dish) throws DishAlreadyExistsException{
        return this.dishService.save(dish);
    }
    public List<Dish> getAllDishes(){
        return this.dishService.getAllDishes();
    }
    public Dish getDishById(String id) throws DishNotFoundException{
        return this.dishService.getDishById(id);
    }
    public Dish updateDish(Dish dish) throws DishNotFoundException{
        return this.dishService.updateDish(dish);
    }
    public void deleteDish(String id) throws DishNotFoundException{
        this.dishService.deleteDish(id);
    }
}
