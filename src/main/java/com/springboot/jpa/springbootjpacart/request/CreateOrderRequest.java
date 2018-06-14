package com.springboot.jpa.springbootjpacart.request;

import com.springboot.jpa.springbootjpacart.entity.OrdersItem;
import com.springboot.jpa.springbootjpacart.validation.CreateOrderValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CreateOrderValidation
public class CreateOrderRequest {

    private String ordersName;
    private String ordersEmail;
    private String ordersAddress;
    private String ordersPhone;
    private List<OrdersItem> itemRequests = new ArrayList<>();
}
