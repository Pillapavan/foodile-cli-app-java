package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.DishNotFoundException;
import com.java.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.java.foodiecli.exceptions.RestaurantNotFoundException;
import com.java.foodiecli.model.Dish;
import com.java.foodiecli.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistsException;
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;
    public void deleteRestaurant(String id) throws RestaurantNotFoundException;
    public List<Restaurant> getAllRestaurants();
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException;
}
