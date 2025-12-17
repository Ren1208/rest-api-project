package ru.semenchenko.project.RestAPI.dto;

import ru.semenchenko.project.RestAPI.models.Sensor;

import java.util.List;

/**
 * @author Artyom Semenchenko
 */
public class SensorsResponse {
    private List<SensorDTO> sensors;

    public SensorsResponse(List<SensorDTO> sensors) {
        this.sensors = sensors;
    }

    public List<SensorDTO> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDTO> sensors) {
        this.sensors = sensors;
    }
}
