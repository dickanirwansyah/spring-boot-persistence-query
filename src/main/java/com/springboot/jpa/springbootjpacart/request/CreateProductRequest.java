package com.springboot.jpa.springbootjpacart.request;

import com.springboot.jpa.springbootjpacart.entity.Status;
import com.springboot.jpa.springbootjpacart.validation.CreateProductValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CreateProductValidation
public class CreateProductRequest {

    private String requestName;
    private int requestPrice;
    private int requestStock;
    private Status status;
}
