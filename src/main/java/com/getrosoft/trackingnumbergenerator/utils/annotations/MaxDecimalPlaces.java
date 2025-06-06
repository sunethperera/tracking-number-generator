package com.getrosoft.trackingnumbergenerator.utils.annotations;

import com.getrosoft.trackingnumbergenerator.utils.validator.MaxDecimalPlaceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MaxDecimalPlaceValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxDecimalPlaces {
    String message() default "Invalid decimal format.Maximum 3 decimal places are allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int maxDecimalPlaces() default 3;
}
