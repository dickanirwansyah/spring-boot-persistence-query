package com.springboot.jpa.springbootjpacart.repository;

import com.springboot.jpa.springbootjpacart.entity.Product;
import com.springboot.jpa.springbootjpacart.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String>{

    @Query("FROM Product AS p WHERE p.status.idstatus=1")
    List<Product> findByStatus();
}
