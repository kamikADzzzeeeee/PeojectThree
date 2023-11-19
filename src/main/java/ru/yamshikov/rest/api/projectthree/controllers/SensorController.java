package ru.yamshikov.rest.api.projectthree.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorDtoInfo;
import ru.yamshikov.rest.api.projectthree.mapper.sensor.SensorMapperInfo;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.services.SensorService;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.EmptySensorListException;

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


}
