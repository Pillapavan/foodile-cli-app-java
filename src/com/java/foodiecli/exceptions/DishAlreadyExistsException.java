package com.java.foodiecli.exceptions;

public class DishAlreadyExistsException extends Exception{
    public DishAlreadyExistsException(String message) {
        super(message);
    }
}
