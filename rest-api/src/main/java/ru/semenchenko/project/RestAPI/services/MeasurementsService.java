package ru.semenchenko.project.RestAPI.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.semenchenko.project.RestAPI.models.Measurement;
import ru.semenchenko.project.RestAPI.repositories.MeasurementRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Artyom Semenchenko
 */

@Service
@Transactional(readOnly = true)
public class MeasurementsService {

    private final MeasurementRepository measurementRepository;
    private final SensorsService sensorsService;

    public MeasurementsService(MeasurementRepository measurementRepository, SensorsService sensorsService) {
        this.measurementRepository = measurementRepository;
        this.sensorsService = sensorsService;
    }

    @Transactional
    public void add(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setMeasurementTime(LocalDateTime.now());
        measurement.setSensor(sensorsService.getSensorByName(measurement.getSensor().getName()).get());
    }

}
