package ru.semenchenko.project.rest_api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.semenchenko.project.rest_api.models.Sensor;
import ru.semenchenko.project.rest_api.repositories.SensorRepository;

import java.util.Optional;

/**
 * @author Artyom Semenchenko
 */

@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorRepository sensorRepository;

    public SensorsService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Optional<Sensor> getSensorByName(String name) {
        return sensorRepository.findByName(name);
    }
}
