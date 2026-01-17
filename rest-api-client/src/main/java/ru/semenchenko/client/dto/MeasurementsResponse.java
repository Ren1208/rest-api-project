package ru.semenchenko.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Artyom Semenchenko
 */

@Getter
@Setter
public class MeasurementsResponse {
    private List<MeasurementDTO> measurements;

}
