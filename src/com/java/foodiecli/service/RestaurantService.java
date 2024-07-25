package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.java.foodiecli.exceptions.RestaurantNotFoundException;
import com.java.foodiecli.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException;
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;
    public Restaurant deleteRestaurant(Restaurant restaurant);

}
