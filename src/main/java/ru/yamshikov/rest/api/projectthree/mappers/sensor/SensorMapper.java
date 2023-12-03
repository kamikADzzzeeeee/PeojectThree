package ru.yamshikov.rest.api.projectthree.mappers.sensor;

import org.mapstruct.Mapper;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorDto;
import ru.yamshikov.rest.api.projectthree.models.Sensor;

@Mapper(componentModel = "spring")
public interface SensorMapper {

    SensorDto toDto(Sensor entity);

    Sensor toEntity(SensorDto dto);


}
