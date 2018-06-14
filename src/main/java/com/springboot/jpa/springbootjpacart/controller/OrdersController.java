package com.springboot.jpa.springbootjpacart.controller;

import com.springboot.jpa.springbootjpacart.entity.Orders;
import com.springboot.jpa.springbootjpacart.request.CreateOrderRequest;
import com.springboot.jpa.springbootjpacart.response.ErrorResponse;
import com.springboot.jpa.springbootjpacart.service.OrdersService;
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
@RequestMapping(value = "/order/v1/api")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public ResponseEntity<List<Orders>> listOrders(){
        return Optional.ofNullable(ordersService.listOrders())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/created")
    public ResponseEntity<Orders> create(@Valid @RequestBody CreateOrderRequest request){
        return Optional.ofNullable(ordersService.createOrders(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Orders>(HttpStatus.BAD_REQUEST));
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
