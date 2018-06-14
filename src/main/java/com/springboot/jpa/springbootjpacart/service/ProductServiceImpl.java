package com.springboot.jpa.springbootjpacart.service;

import com.springboot.jpa.springbootjpacart.entity.Product;
import com.springboot.jpa.springbootjpacart.entity.Status;
import com.springboot.jpa.springbootjpacart.repository.ProductRepository;
import com.springboot.jpa.springbootjpacart.repository.StatusRepository;
import com.springboot.jpa.springbootjpacart.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Product> listProduct() {
        List<Product> list = new ArrayList<>();
        for (Product product : productRepository.findAll()){
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> listProductByActive() {
        List<Product> list = new ArrayList<>();
        for (Product product : productRepository.findByStatus()){
            list.add(product);
        }
        return list;
    }


    @Override
    public Product createProduct(CreateProductRequest requestProduct) {
        Product product = newProduct(
                requestProduct.getRequestName(),
                requestProduct.getRequestPrice(),
                requestProduct.getRequestStock(),
                requestProduct.getStatus());
        return productRepository.save(product);
    }

    private Product newProduct(String name, int price, int stock, Status status){
        return Product.builder()
                .name(name)
                .price(price)
                .stock(stock)
                .status(status)
                .build();
    }

}
