package ru.semenchenko.project.rest_api.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.semenchenko.project.rest_api.models.Measurement;
import ru.semenchenko.project.rest_api.services.SensorsService;

/**
 * @author Artyom Semenchenko
 */

@Component
public class MeasurementValidator implements Validator {

    private final SensorsService sensorsService;

    public MeasurementValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;

        if (measurement.getSensor() == null) {
            return;
        }

        if (sensorsService.getSensorByName(measurement.getSensor().getName()).isEmpty()) {
            errors.rejectValue("sensor",
                    "Сенсор с таким названием не зарегистрирован!");
        }
    }

}
