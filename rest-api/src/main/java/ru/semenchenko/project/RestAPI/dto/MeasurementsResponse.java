package ru.semenchenko.project.RestAPI.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Artyom Semenchenko
 */

@Setter
@Getter
public class MeasurementsResponse {
    private List<MeasurementDTO> measurements;

    public MeasurementsResponse(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }

}
