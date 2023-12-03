package ru.yamshikov.rest.api.projectthree.mappers.sensor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorDetailsDto;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorDto;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorWithDetailsDto;

@Mapper(componentModel = "spring")
public interface SensorWithDetailMapper {

    @Mapping(target = "id", source = "sensorDto.id")
    SensorWithDetailsDto toDto(SensorDto sensorDto, SensorDetailsDto details);


}
