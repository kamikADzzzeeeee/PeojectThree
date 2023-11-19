package ru.yamshikov.rest.api.projectthree.mapper.sensor;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorDtoInfo;
import ru.yamshikov.rest.api.projectthree.models.Sensor;

@Component
@AllArgsConstructor
public class SensorMapperInfo {

    private final ModelMapper modelMapper;

    public Sensor toEntity(SensorDtoInfo dto){
        return modelMapper.map(dto, Sensor.class);
    }

    public SensorDtoInfo toDto(Sensor entity){
        return modelMapper.map(entity,SensorDtoInfo.class);
    }

}