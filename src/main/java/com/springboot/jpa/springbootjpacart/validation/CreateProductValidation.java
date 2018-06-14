package com.springboot.jpa.springbootjpacart.validation;

import com.springboot.jpa.springbootjpacart.validation.validator.CreateProductValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ANNOTATION_TYPE, TYPE, METHOD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {CreateProductValidator.class})
@Documented
public @interface CreateProductValidation {

    String message() default "CreateProductValidation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
