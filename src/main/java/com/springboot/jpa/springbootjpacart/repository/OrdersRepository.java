package com.springboot.jpa.springbootjpacart.repository;

import com.springboot.jpa.springbootjpacart.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, String> {
}
