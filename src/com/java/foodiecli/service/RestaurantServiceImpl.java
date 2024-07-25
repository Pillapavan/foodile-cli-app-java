package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.java.foodiecli.exceptions.RestaurantNotFoundException;
import com.java.foodiecli.model.Restaurant;
import com.java.foodiecli.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService {


    RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.getRestaurantById(restaurant.getRestaurantId());
        if (restaurantById.isPresent()) {
            throw new RestaurantAlreadyExistsException("Restaurant Already exists with  this id" + restaurant.getRestaurantId());
        }
        return this.restaurantRepository.saveRestaurant(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantFound=this.restaurantRepository.getRestaurantById(restaurant.getRestaurantId());
        if (restaurantFound.isEmpty()){
            throw new RestaurantNotFoundException("Restaurant Not Found with this id"+restaurant.getRestaurantId());
        }
         return this.restaurantRepository.updateRetaurant(restaurant);

    }

    @Override
    public Restaurant deleteRestaurant(Restaurant restaurant) {
        return null;
    }
}