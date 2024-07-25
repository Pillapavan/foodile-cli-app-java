package com.java.foodiecli.controller;

import com.java.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.java.foodiecli.model.Restaurant;
import com.java.foodiecli.repository.RestaurantRepository;

public class RestaurantController {
    RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException{
        return this.restaurantRepository.saveRestaurant(restaurant);
    }

}
