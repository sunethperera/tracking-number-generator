package com.getrosoft.trackingnumbergenerator.utils.annotations;

import com.getrosoft.trackingnumbergenerator.utils.validator.ISO31661Alpha2Validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ISO31661Alpha2Validator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ISO31661Alpha2 {
    String message() default "Invalid ISO 3166-1 alpha-2 country code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
