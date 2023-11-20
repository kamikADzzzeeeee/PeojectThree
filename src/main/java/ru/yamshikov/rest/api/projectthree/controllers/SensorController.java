package ru.yamshikov.rest.api.projectthree.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.yamshikov.rest.api.projectthree.dto.SensorDtoInOut;
import ru.yamshikov.rest.api.projectthree.mapper.SensorMapper;
import ru.yamshikov.rest.api.projectthree.services.SensorService;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorNotCreatedException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sensors")
@AllArgsConstructor
public class SensorController {

    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    @GetMapping()
    public ResponseEntity<List<SensorDtoInOut>> sensorsPage(){
        List<SensorDtoInOut> sensors = sensorService.findAllSensors()
                .stream()
                .map(sensorMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(sensors, HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registrationPage(@RequestBody @Valid SensorDtoInOut dtoInfo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            StringBuilder result = new StringBuilder();
            for (FieldError error : errors){
                result.append(error.getField())
                      .append(" - ")
                      .append(error.getDefaultMessage())
                      .append("; ");
            }
            throw new SensorNotCreatedException(result.toString());
        }
        sensorService.creatSensor(sensorMapper.toEntity(dtoInfo));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
