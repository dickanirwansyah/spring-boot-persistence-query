package com.springboot.jpa.springbootjpacart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String msg){
        super(msg);
    }

    public ProductNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
