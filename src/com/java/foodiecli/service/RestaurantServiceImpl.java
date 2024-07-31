package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.DishNotFoundException;
import com.java.foodiecli.exceptions.RestaurantAlreadyExistsException;
import com.java.foodiecli.exceptions.RestaurantNotFoundException;
import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.model.Dish;
import com.java.foodiecli.model.Restaurant;
import com.java.foodiecli.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService {


    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistsException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.getRestaurantById(restaurant.getRestaurantId());
        if (restaurantById.isPresent()) {
            throw new RestaurantAlreadyExistsException("Restaurant Already exists with  this id" + restaurant.getRestaurantId());
        }
        return this.restaurantRepository.saveRestaurant(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById=this.restaurantRepository.getRestaurantById(restaurant.getRestaurantId());
        if (restaurantById.isEmpty()){
            throw new RestaurantNotFoundException("Restaurant Not Found with this id"+restaurant.getRestaurantId());
        }
         return this.restaurantRepository.updateRestaurant(restaurant);

    }

    @Override
    public void deleteRestaurant(String id) throws RestaurantNotFoundException {
          Optional<Restaurant> restaurantById=this.restaurantRepository.getRestaurantById(id);
          if (restaurantById.isEmpty()){
              throw new RestaurantNotFoundException("Restaurant Not Found with this id"+id);
          }
          this.restaurantRepository.deleteRestaurant(restaurantById.get());
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.getAllRestaurants();
    }

    @Override
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
       Optional<Restaurant> restaurantById=this.restaurantRepository.getRestaurantById(id);
       if (restaurantById.isEmpty()){
           throw new RestaurantNotFoundException("Restaurant Not Found with this id"+id);
       }
       return restaurantById.get();
    }
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.getRestaurantById(id);
        if(restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant Not Found with this Id  :" + id);
        List<Dish> dishList = new ArrayList<>();
        Restaurant restaurant = restaurantById.get();
        List<String> dishIds = restaurant.getMenu();
        DishService dishService = Factory.getDishService();
        for(String dishId : dishIds){
            Dish dish = dishService.getDishById(dishId);
            dishList.add(dish);
        }
        return dishList;
    }
}