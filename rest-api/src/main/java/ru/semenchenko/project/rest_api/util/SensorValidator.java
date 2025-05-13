package ru.semenchenko.project.rest_api.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.semenchenko.project.rest_api.models.Sensor;
import ru.semenchenko.project.rest_api.services.SensorsService;

/**
 * @author Artyom Semenchenko
 */

@Component
public class SensorValidator implements Validator {

    private final SensorsService sensorsService;

    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;

        if (sensorsService.getSensorByName(sensor.getName()).isPresent()) {
            errors.rejectValue("name", "Сенсор с таким названием уже зарегистрирован!");
        }
    }
}
