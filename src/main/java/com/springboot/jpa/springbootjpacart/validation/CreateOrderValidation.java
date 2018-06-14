package com.springboot.jpa.springbootjpacart.validation;

import com.springboot.jpa.springbootjpacart.validation.validator.CreateOrderValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;

@Target({ANNOTATION_TYPE, TYPE, METHOD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {
        CreateOrderValidator.class
})
@Documented
public @interface CreateOrderValidation {

    String message() default "CreateOrderValidation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};

    interface productInOrdesItem{

        String getProductId();
    }
}
