package ru.semenchenko.project.RestAPI.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ru.semenchenko.project.RestAPI.models.Sensor;

/**
 * @author Artyom Semenchenko
 */

public class MeasurementDTO {

    @NotNull
    @Max(100)
    @Min(-100)
    private Double value;

    @NotNull
    private Boolean raining;

    @NotNull
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
