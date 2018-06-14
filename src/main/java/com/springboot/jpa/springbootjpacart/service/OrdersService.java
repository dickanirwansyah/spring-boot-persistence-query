package com.springboot.jpa.springbootjpacart.service;

import com.springboot.jpa.springbootjpacart.entity.Orders;
import com.springboot.jpa.springbootjpacart.request.CreateOrderRequest;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    Orders createOrders(CreateOrderRequest requestOrders);
    List<Orders> listOrders();
}
