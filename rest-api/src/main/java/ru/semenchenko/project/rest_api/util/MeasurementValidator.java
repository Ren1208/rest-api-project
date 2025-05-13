package ru.semenchenko.project.rest_api.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.semenchenko.project.rest_api.models.Measurement;

/**
 * @author Artyom Semenchenko
 */

@Component
public class MeasurementValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;
    }

}
