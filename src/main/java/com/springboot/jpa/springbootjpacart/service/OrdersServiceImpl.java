package com.springboot.jpa.springbootjpacart.service;

import com.springboot.jpa.springbootjpacart.entity.Orders;
import com.springboot.jpa.springbootjpacart.entity.OrdersItem;
import com.springboot.jpa.springbootjpacart.repository.OrdersRepository;
import com.springboot.jpa.springbootjpacart.request.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders createOrders(CreateOrderRequest requestOrders) {
        Orders orders = newOrders(
                requestOrders.getOrdersName(),
                requestOrders.getOrdersEmail(),
                requestOrders.getOrdersAddress(),
                requestOrders.getOrdersPhone(),
                requestOrders.getItemRequests()
        );
        return ordersRepository.save(orders);
    }

    private Orders newOrders(String name, String email, String address, String phone, List<OrdersItem> requests){
        return Orders.builder()
                .name(name)
                .email(email)
                .address(address)
                .phone(phone)
                .ordersItems(requests)
                .build();
    }

    @Override
    public List<Orders> listOrders() {
        return ordersRepository.findAll();
    }
}
