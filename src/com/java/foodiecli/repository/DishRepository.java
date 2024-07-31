package com.java.foodiecli.repository;

import com.java.foodiecli.exceptions.DishNotFoundException;
import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.model.Dish;

import java.util.List;
import java.util.Optional;

public class DishRepository {
    private final List<Dish> dishList;

    public DishRepository() {
        this.dishList = Factory.getCsvReader().readDishesFromCsv();
    }
    public List<Dish> getAllDishes(){
       return dishList;
    }

    public Dish saveDish(Dish dish){
        this.dishList.add(dish);
        return dish;
    }
    public Optional<Dish> findDishById(String id)  {
        return  this.dishList.stream().filter(dish -> dish.getDishId().equals(id)).findFirst();
    }
    public Dish updateDish(Dish dishToBeUpdated) throws DishNotFoundException{
         Optional<Dish> optionalDish = this.dishList.stream().filter(dish -> dish.getDishId().equals(dishToBeUpdated.getDishId()))
                .findFirst()
                .map(Dish -> {
                    Dish.setDishName(dishToBeUpdated.getDishName())
                            .setDescription(dishToBeUpdated.getDescription())
                            .setPrice(dishToBeUpdated.getPrice());
                    return Dish;
                });
         return optionalDish.orElse(null);
    }
    public void deleteDish(Dish dish){
        this.dishList.remove(dish);
    }

}
