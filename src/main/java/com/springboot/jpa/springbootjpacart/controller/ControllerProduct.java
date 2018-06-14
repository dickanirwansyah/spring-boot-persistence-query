package com.springboot.jpa.springbootjpacart.controller;

import com.springboot.jpa.springbootjpacart.entity.Product;
import com.springboot.jpa.springbootjpacart.request.CreateProductRequest;
import com.springboot.jpa.springbootjpacart.response.ErrorResponse;
import com.springboot.jpa.springbootjpacart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product/api/v1")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/active")
    public ResponseEntity<List<Product>> active(){
        return Optional.ofNullable(productService.listProductByActive())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Product>> list(){
        List<Product> products = productService.listProduct();
        if (products.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Product> create (@Valid @RequestBody CreateProductRequest request){
        return Optional.ofNullable(productService.createProduct(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Product>(HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlingError(MethodArgumentNotValidException exception){

        String message = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());

        return ErrorResponse
                .builder()
                .message(message)
                .date(new Date())
                .status(false)
                .build();
    }

}
