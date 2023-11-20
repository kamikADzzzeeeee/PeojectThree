package ru.yamshikov.rest.api.projectthree.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yamshikov.rest.api.projectthree.models.Measurement;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.repositories.MeasurementRepository;
import ru.yamshikov.rest.api.projectthree.repositories.SensorRepository;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.measurement.EmptyMeasurementListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorNotRegistratedException;

import java.util.*;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    public Set<Sensor> findAllMeasurement(){
        Set<Sensor> setSensor = new HashSet<Sensor>(measurementRepository.findAllMeasurementWithSensor());
        if (setSensor.isEmpty()){
            throw new EmptyMeasurementListException();
        }
        return setSensor;
    }


    public void registratedMeasurement(Measurement measurement){
        Optional<Sensor> sensor = sensorRepository.findBySerialNumber(measurement.getSensor().getSerialNumber());
        if (sensor.isEmpty()) {
            throw new SensorNotRegistratedException();
        }
        measurementRepository.save(measurement);
    }

}
