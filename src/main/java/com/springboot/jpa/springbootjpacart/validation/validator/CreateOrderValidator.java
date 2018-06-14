package com.springboot.jpa.springbootjpacart.validation.validator;

import com.springboot.jpa.springbootjpacart.repository.ProductRepository;
import com.springboot.jpa.springbootjpacart.request.CreateOrderRequest;
import com.springboot.jpa.springbootjpacart.validation.CreateOrderValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CreateOrderValidator implements ConstraintValidator<CreateOrderValidation, CreateOrderRequest>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(CreateOrderValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateOrderRequest value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        if (value.getOrdersName() == null || value.getOrdersName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("nama must exits")
                    .addPropertyNode("ordersName")
                    .addConstraintViolation();
            return false;
        }

        if (value.getOrdersEmail() == null || value.getOrdersEmail().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("email must exists")
                    .addPropertyNode("ordersEmail")
                    .addConstraintViolation();
            return false;
        }

        if (value.getOrdersAddress() == null || value.getOrdersAddress().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("address must exists")
                    .addPropertyNode("ordersAddress")
                    .addConstraintViolation();
            return false;
        }

        if (value.getOrdersPhone() == null || value.getOrdersPhone().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("phone must exists")
                    .addPropertyNode("ordersPhone")
                    .addConstraintViolation();
            return false;
        }

        if (value.getItemRequests() == null || value.getItemRequests().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("orders item must exists")
                    .addPropertyNode("itemRequests")
                    .addConstraintViolation();
            return false;
        }


        return true;
    }
}
