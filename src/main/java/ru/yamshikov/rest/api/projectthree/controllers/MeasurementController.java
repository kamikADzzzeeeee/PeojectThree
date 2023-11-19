package ru.yamshikov.rest.api.projectthree.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.yamshikov.rest.api.projectthree.dto.MeasurementSensorDtoIn;
import ru.yamshikov.rest.api.projectthree.dto.SensorListMeasurementsDtoOut;
import ru.yamshikov.rest.api.projectthree.mapper.MeasurementMapper;
import ru.yamshikov.rest.api.projectthree.mapper.MeasurementSensorMapper;
import ru.yamshikov.rest.api.projectthree.mapper.SensorMapper;
import ru.yamshikov.rest.api.projectthree.models.Measurement;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.services.MeasurementService;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.measurement.MeasurementNotRegistratedException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorNotCreatedException;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/measurements")
@AllArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;
    private final MeasurementMapper measurementMapper;
    private final MeasurementSensorMapper measurementSensorMapper;
    private final SensorMapper sensorMapper;

    @GetMapping()
    public ResponseEntity<Set<SensorListMeasurementsDtoOut>>  measurementsPage(){
        Set<Sensor> setSensor =  measurementService.findAllMeasurement();
        return new ResponseEntity<>(
                SensorListMeasurementsDtoOut.toSet(setSensor, measurementMapper, sensorMapper),
                HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addPage(@RequestBody @Valid MeasurementSensorDtoIn dtoInfo, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            StringBuilder result = new StringBuilder();
            for (FieldError error : errors){
                result.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append("; ");
            }
            throw new MeasurementNotRegistratedException(result.toString());
        }

        Measurement measurement = MeasurementSensorDtoIn.toMeasurement(
                dtoInfo,
                measurementSensorMapper,
                sensorMapper,
                measurementMapper);

        System.out.println(measurement);
        return new ResponseEntity<>(HttpStatus.OK);
    }








}
