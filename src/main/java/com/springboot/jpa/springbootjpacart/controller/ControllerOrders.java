package com.springboot.jpa.springbootjpacart.controller;

import com.springboot.jpa.springbootjpacart.entity.Orders;
import com.springboot.jpa.springbootjpacart.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/orders/v1")
public class ControllerOrders {

    @Autowired
    private OrdersRepository ordersRepository;

    @PostMapping(value = "/create")
    public Orders create(@RequestBody Orders orders){
        return ordersRepository.save(orders);
    }

    @GetMapping(value = "/{id}")
    public Optional<Orders> byId(@PathVariable String id){
        return ordersRepository.findById(id);
    }
}
