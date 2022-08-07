package com.springmvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springmvc.dto.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {


    public void initialize(final PasswordMatches constraintAnnotation) {
    }

    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            UserDto user = (UserDto) value;
            return user.getPassword().equals(user.getConfirmPassword());
        } catch (final Exception ex) {
            //LOG.info("Error while getting values from object", ex);
            return false;
        }

    }

}