package ru.yamshikov.rest.api.projectthree.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yamshikov.rest.api.projectthree.dto.SensorDtoInfo;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractMapper;

@Component
public class SensorMapperInfo extends AbstractMapper<Sensor,SensorDtoInfo> {

    @Autowired
    public SensorMapperInfo() {
        super(Sensor.class, SensorDtoInfo.class);
    }

}