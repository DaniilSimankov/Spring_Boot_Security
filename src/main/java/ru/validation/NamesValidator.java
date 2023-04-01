package ru.validation;

import ru.dto.SignUpForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NamesValidator implements ConstraintValidator<NotSameNames, SignUpForm> {
    @Override
    public boolean isValid(SignUpForm value, ConstraintValidatorContext constraintValidatorContext) {
        return !value.getFirstName().equals(value.getLastName());
    }
}
