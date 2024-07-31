package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.DishAlreadyExistsException;
import com.java.foodiecli.exceptions.DishNotFoundException;
import com.java.foodiecli.model.Dish;
import com.java.foodiecli.repository.DishRepository;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    @Override
    public List<Dish> getAllDishes() {
        return this.dishRepository.getAllDishes();
    }

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish save(Dish dish) throws DishAlreadyExistsException {
        Optional<Dish> dishById=this.dishRepository.findDishById(dish.getDishId());
        if (dishById.isPresent()){
            throw  new DishAlreadyExistsException("Dish Already Exists with this Id:"+dish.getDishId());
        }
     return this.dishRepository.saveDish(dish);
    }
    @Override
    public Dish getDishById(String id) throws DishNotFoundException {
        Optional<Dish> dishById=this.dishRepository.findDishById(id);
        if (dishById.isEmpty()){
            throw new DishNotFoundException("Dish Not Found with this Id:"+id);
        }
        return dishById.get();
    }

    @Override
    public Dish updateDish(Dish dish) throws DishNotFoundException {
        Optional<Dish> dishById=this.dishRepository.findDishById(dish.getDishId());
        if (dishById.isEmpty()){
            throw new DishNotFoundException("Dish is Not Found With this Id:"+dish.getDishId());
        }
       return this.dishRepository.updateDish(dish);
    }

    @Override
    public void deleteDish(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.findDishById(id);
        if (dishById.isEmpty()) {
            throw new DishNotFoundException("Dish is Not Found With this Id:" + id);
        }
        this.dishRepository.deleteDish(dishById.get());
    }
}
