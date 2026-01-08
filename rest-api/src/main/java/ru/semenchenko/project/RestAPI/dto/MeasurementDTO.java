package ru.semenchenko.project.RestAPI.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ru.semenchenko.project.RestAPI.models.Sensor;

import java.time.LocalDateTime;

/**
 * @author Artyom Semenchenko
 */

@Setter
@Getter
public class MeasurementDTO {

    @NotNull
    @Max(100)
    @Min(-100)
    private Double value;

    @NotNull
    private Boolean raining;

    @NotNull
    private LocalDateTime measurementTime;

    @NotNull
    private String sensorName;

}
