package com.getrosoft.trackingnumbergenerator.utils.validator;

import com.getrosoft.trackingnumbergenerator.utils.annotations.ISO31661Alpha2;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Locale;

public class ISO31661Alpha2Validator implements ConstraintValidator<ISO31661Alpha2, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return Arrays.asList(Locale.getISOCountries()).contains(value);
    }
}
