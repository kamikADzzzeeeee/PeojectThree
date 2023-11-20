package ru.yamshikov.rest.api.projectthree.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.yamshikov.rest.api.projectthree.dto.SensorDtoInfo;
import ru.yamshikov.rest.api.projectthree.mapper.SensorMapperInfo;
import ru.yamshikov.rest.api.projectthree.services.SensorService;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.EmptySensorListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.SensorNotCreatedException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sensors")
@AllArgsConstructor
public class SensorController {

    private final SensorService sensorService;
    private final SensorMapperInfo sensorMapperInfo;

    @GetMapping()
    public ResponseEntity<List<SensorDtoInfo>> sensorsPage(){
        List<SensorDtoInfo> sensors = sensorService.findAllSensors()
                .stream()
                .map(sensorMapperInfo::toDto)
                .collect(Collectors.toList());
        if (sensors.isEmpty()){
            throw new EmptySensorListException();
        } else {
            return new ResponseEntity<>(sensors, HttpStatus.OK);
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registrationPage(@RequestBody @Valid SensorDtoInfo dtoInfo,
                                                       BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            StringBuilder result = new StringBuilder();
            for (FieldError error : errors){
                result.append(error.getField())
                      .append(" - ")
                      .append(error.getDefaultMessage())
                      .append(";");
            }
            throw new SensorNotCreatedException(result.toString());
        }
        sensorService.creatSensor(sensorMapperInfo.toEntity(dtoInfo));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
