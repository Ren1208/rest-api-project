package ru.semenchenko.project.RestAPI.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.semenchenko.project.RestAPI.dto.MeasurementDTO;
import ru.semenchenko.project.RestAPI.dto.MeasurementsResponse;
import ru.semenchenko.project.RestAPI.models.Measurement;
import ru.semenchenko.project.RestAPI.services.MeasurementsService;
import ru.semenchenko.project.RestAPI.util.MeasurementErrorResponse;
import ru.semenchenko.project.RestAPI.util.MeasurementException;
import ru.semenchenko.project.RestAPI.util.MeasurementValidator;

import java.util.stream.Collectors;

import static ru.semenchenko.project.RestAPI.util.ErrorsUtil.returnErrorsToClient;

/**
 * @author Artyom Semenchenko
 */

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

    private final ModelMapper modelMapper;
    private final MeasurementValidator measurementValidator;
    private final MeasurementsService measurementsService;

    public MeasurementsController(ModelMapper modelMapper, MeasurementValidator measurementValidator, MeasurementsService measurementsService) {
        this.modelMapper = modelMapper;
        this.measurementValidator = measurementValidator;
        this.measurementsService = measurementsService;
    }

    @PostMapping("/add")
    public HttpEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO,
                                                 BindingResult bindingResult) {
        Measurement measurement = convertToMeasurement(measurementDTO);

        measurementValidator.validate(measurement, bindingResult);

        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        measurementsService.add(measurement);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping()
    public MeasurementsResponse getAllMeasurements() {
        return new MeasurementsResponse(measurementsService.findAll()
                .stream()
                .map(this::convertToMeasurementDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/rainyDaysCount")
    public Long rainyDaysCount() {
        return measurementsService.findAll()
                .stream()
                .filter(Measurement::isRaining)
                .count();
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException e) {
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement) {
        return modelMapper.map(measurement, MeasurementDTO.class);
    }
}
