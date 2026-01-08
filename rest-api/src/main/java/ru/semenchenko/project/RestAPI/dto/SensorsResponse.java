package ru.semenchenko.project.RestAPI.dto;

import lombok.Getter;
import lombok.Setter;
import ru.semenchenko.project.RestAPI.models.Sensor;

import java.util.List;

/**
 * @author Artyom Semenchenko
 */
@Setter
@Getter
public class SensorsResponse {
    private List<SensorDTO> sensors;

    public SensorsResponse(List<SensorDTO> sensors) {
        this.sensors = sensors;
    }

}
