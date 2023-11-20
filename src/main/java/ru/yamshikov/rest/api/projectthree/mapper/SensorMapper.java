package ru.yamshikov.rest.api.projectthree.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yamshikov.rest.api.projectthree.dto.SensorDtoInOut;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractMapper;

@Component
public class SensorMapper extends AbstractMapper<Sensor, SensorDtoInOut> {

    @Autowired
    public SensorMapper() {
        super(Sensor.class, SensorDtoInOut.class);
    }

}