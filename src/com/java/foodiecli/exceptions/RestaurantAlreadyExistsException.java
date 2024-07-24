package com.java.foodiecli.exceptions;

public class RestaurantAlreadyExistsException extends Exception{
    public RestaurantAlreadyExistsException(String message){
        super(message);
    }
}
