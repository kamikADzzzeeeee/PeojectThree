package ru.yamshikov.rest.api.projectthree.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.repositories.SensorRepository;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.SensorAlreadyExistsException;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    public List<Sensor> findAllSensors(){
        return sensorRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void creatSensor(Sensor sensor){
        sensorRepository.findBySerialNumber(sensor.getSerialNumber()).ifPresent(action ->{
            throw new SensorAlreadyExistsException();
        });
        sensorRepository.save(sensor);
    }


}
