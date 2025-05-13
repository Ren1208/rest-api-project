package ru.semenchenko.project.RestAPI.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.semenchenko.project.RestAPI.models.Sensor;
import ru.semenchenko.project.RestAPI.repositories.SensorRepository;

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

    @Transactional
    public void register(Sensor sensor) {
        sensorRepository.save(sensor);
    }

}
