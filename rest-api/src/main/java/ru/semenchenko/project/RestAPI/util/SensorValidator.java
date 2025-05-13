package ru.semenchenko.project.RestAPI.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.semenchenko.project.RestAPI.models.Sensor;
import ru.semenchenko.project.RestAPI.services.SensorsService;

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
