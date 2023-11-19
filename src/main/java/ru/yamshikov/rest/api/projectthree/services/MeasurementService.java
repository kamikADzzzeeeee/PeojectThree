package ru.yamshikov.rest.api.projectthree.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.repositories.MeasurementRepository;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.measurement.EmptyMeasurementListException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    public Set<Sensor> findAllMeasurement(){
        Set<Sensor> setSensor = new HashSet<Sensor>(measurementRepository.findAllMeasurementWithSensor());
        if (setSensor.isEmpty()){
            throw new EmptyMeasurementListException();
        }
        return setSensor;
    }

}
