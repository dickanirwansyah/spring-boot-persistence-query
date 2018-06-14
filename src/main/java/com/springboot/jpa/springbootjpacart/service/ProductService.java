package com.springboot.jpa.springbootjpacart.service;

import com.springboot.jpa.springbootjpacart.entity.Product;
import com.springboot.jpa.springbootjpacart.request.CreateProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> listProduct();
    List<Product> listProductByActive();
    List<Product> listProductByDeactive();
    Product createProduct(CreateProductRequest requestProduct);
}
