package com.java.foodiecli.service;

import com.java.foodiecli.exceptions.OrderAlreadyExistsException;
import com.java.foodiecli.exceptions.OrderNotFoundException;
import com.java.foodiecli.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Order save(Order order);
    public List<Order> getOrdersList();
    public Order getOrderById(String id) throws OrderNotFoundException;
}
