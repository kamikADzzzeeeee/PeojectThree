package ru.yamshikov.rest.api.projectthree.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.repositories.SensorRepository;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.EmptySensorListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorAlreadyExistsException;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    public List<Sensor> findAllSensors(){
        List<Sensor> sensors = sensorRepository.findAll();
        if (sensors.isEmpty()){
            throw new EmptySensorListException();
        }
        return sensors;
    }

    @Transactional(readOnly = false)
    public void creatSensor(Sensor sensor){
        sensorRepository.findBySerialNumber(sensor.getSerialNumber()).ifPresent(action ->{
            throw new SensorAlreadyExistsException();
        });
        sensorRepository.save(sensor);
    }


}
