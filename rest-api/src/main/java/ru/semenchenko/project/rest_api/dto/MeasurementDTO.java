package ru.semenchenko.project.rest_api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import ru.semenchenko.project.rest_api.models.Sensor;

/**
 * @author Artyom Semenchenko
 */

public class MeasurementDTO {

    @NotEmpty
    @Max(100)
    @Min(-100)
    private Double value;

    @NotEmpty
    private Boolean raining;

    @NotEmpty
    private Sensor sensor;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
