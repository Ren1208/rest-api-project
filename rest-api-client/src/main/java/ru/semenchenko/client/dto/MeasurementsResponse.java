package ru.semenchenko.client.dto;

import java.util.List;

/**
 * @author Artyom Semenchenko
 */

public class MeasurementsResponse {
    private List<MeasurementDTO> measurements;

    public List<MeasurementDTO> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }
}
