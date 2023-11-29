package ru.yamshikov.rest.api.projectthree.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yamshikov.rest.api.projectthree.dto.measurement.RegistrationMeasurementDto;
import ru.yamshikov.rest.api.projectthree.mappers.measurement.MeasurementMapper;
import ru.yamshikov.rest.api.projectthree.mappers.measurement.RegistrationMeasurementMapper;
import ru.yamshikov.rest.api.projectthree.mappers.sensor.SensorMapper;
import ru.yamshikov.rest.api.projectthree.models.Measurement;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.repositories.MeasurementRepository;
import ru.yamshikov.rest.api.projectthree.repositories.SensorRepository;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.measurement.EmptyMeasurementListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorNotRegistratedException;

import java.util.*;

@Service
@AllArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    private final RegistrationMeasurementMapper registrationMeasurementMapper;
    private final MeasurementMapper measurementMapper;
    private final SensorMapper sensorMapper;

    @Transactional(readOnly = true)
    public Set<Sensor> findAllMeasurement(){
        Set<Sensor> setSensors = new HashSet<>(measurementRepository.findAllMeasurementWithSensor());
        if (setSensors.isEmpty()){
            throw new EmptyMeasurementListException();
        }
        return setSensors;
    }


    @Transactional(readOnly = false)
    public void registrationMeasurement(RegistrationMeasurementDto dto){
        //Получение измерения из DTO
        Measurement measurement = measurementMapper.toEntity(registrationMeasurementMapper.toMeasurementDto(dto));
        Sensor sensor = sensorMapper.toEntity(registrationMeasurementMapper.toSensorDto(dto));
        //Поиск датчика
        Optional<Sensor> sensorOptional = sensorRepository.findBySerialNumber(sensor.getSerialNumber());
        if (sensorOptional.isEmpty()) {
            throw new SensorNotRegistratedException();
        }
        //внесение изменений в БД
        measurement.setSensor(sensorOptional.get());
        measurementRepository.save(measurement);
    }

    @Transactional(readOnly = true)
    public int getCountAllWeatherDays(String weather){
        List<Measurement> measurements = measurementRepository.findByWeatherEquals(weather);
        if (measurements.isEmpty()){
            throw new EmptyMeasurementListException();
        }
        return measurements.size();
    }

}
