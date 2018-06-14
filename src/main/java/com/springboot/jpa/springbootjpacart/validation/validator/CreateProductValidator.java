package com.springboot.jpa.springbootjpacart.validation.validator;

import com.springboot.jpa.springbootjpacart.entity.Status;
import com.springboot.jpa.springbootjpacart.repository.StatusRepository;
import com.springboot.jpa.springbootjpacart.request.CreateProductRequest;
import com.springboot.jpa.springbootjpacart.validation.CreateProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public class CreateProductValidator implements ConstraintValidator<CreateProductValidation, CreateProductRequest>{

    @Autowired private StatusRepository statusRepository;

    @Override
    public void initialize(CreateProductValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(CreateProductRequest value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        if (value.getRequestName() == null || value.getRequestName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name must exists")
                    .addPropertyNode("requestName")
                    .addConstraintViolation();
            return false;
        }

        if (value.getRequestStock() == 0 || value.getRequestStock() < 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("stock must exists")
                    .addPropertyNode("requestStock")
                    .addConstraintViolation();
            return false;
        }

        if (value.getRequestPrice() == 0 || value.getRequestPrice() < 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("price must exists")
                    .addPropertyNode("requestPrice")
                    .addConstraintViolation();
            return false;
        }

        if (value.getStatus() == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("status must exist")
                    .addPropertyNode("status")
                    .addConstraintViolation();
            return false;
        }

        Optional<Status> status = statusRepository.findById(value.getStatus().getIdstatus());
        if (!status.isPresent()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("status not valid")
                    .addPropertyNode("status")
                    .addConstraintViolation();
            return false;
        }


        return true;
    }
}
