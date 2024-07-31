package com.java.foodiecli.controller;

import com.java.foodiecli.exceptions.OrderAlreadyExistsException;
import com.java.foodiecli.exceptions.OrderNotFoundException;
import com.java.foodiecli.factory.Factory;
import com.java.foodiecli.model.Order;
import com.java.foodiecli.service.OrderServiceImpl;

import java.util.List;

public class OrderController {
      private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService= Factory.getOrderService();
    }

    public Order save(Order order) throws OrderAlreadyExistsException{
        return this.orderService.save(order);
    }
    public List<Order> getOrdersList(){
        return this.orderService.getOrdersList();
    }
    public Order getOrderById(String id) throws OrderNotFoundException{
        return this.orderService.getOrderById(id);
    }
}
