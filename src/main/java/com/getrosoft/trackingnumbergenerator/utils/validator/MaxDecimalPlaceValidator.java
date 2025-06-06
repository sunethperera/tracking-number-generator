package com.getrosoft.trackingnumbergenerator.utils.validator;

import com.getrosoft.trackingnumbergenerator.utils.annotations.MaxDecimalPlaces;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class MaxDecimalPlaceValidator implements ConstraintValidator<MaxDecimalPlaces, Double> {

    private int maxDecimalPlaces;

    @Override
    public void initialize(MaxDecimalPlaces constraintAnnotation) {
        this.maxDecimalPlaces = constraintAnnotation.maxDecimalPlaces();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return BigDecimal.valueOf(value).scale() <= 3;
    }
}
