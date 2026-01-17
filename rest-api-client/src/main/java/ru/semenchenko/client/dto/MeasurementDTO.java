package ru.semenchenko.client.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Artyom Semenchenko
 */


@Getter
@Setter
public class MeasurementDTO {
    private Double value;
    private Boolean raining;
    private SensorDTO sensor;


}
