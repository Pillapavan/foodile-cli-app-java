package com.java.foodiecli.controller;

import com.java.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.java.foodiecli.exceptions.RestaurantNotFoundException;
import com.java.foodiecli.model.Restaurant;
import com.java.foodiecli.service.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {
    private final  RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException{
        return this.restaurantService.saveRestaurant(restaurant);
    }
     public List<Restaurant> getAllRestaurants(){
        return this.restaurantService.getAllRestaurants();
     }
     public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException{
        return this.restaurantService.getRestaurantById(id);
     }
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException{
        return this.restaurantService.updateRestaurant(restaurant);
    }
    public void deleteRestaurant(String id) throws RestaurantNotFoundException{
        this.restaurantService.deleteRestaurant(id);
    }
}
