package com.java.foodiecli.validation;

public class OrderIdValidator {
    private static int orderCounter = 0; // Static counter for generating unique order IDs

    public String generateOrderId() {
        orderCounter++;
        return String.format("O%03d", orderCounter); // Adjusted to accommodate more than 3 digits
    }
}