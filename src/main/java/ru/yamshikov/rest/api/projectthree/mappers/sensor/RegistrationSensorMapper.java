package ru.yamshikov.rest.api.projectthree.mappers.sensor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.yamshikov.rest.api.projectthree.dto.sensor.RegistrationSensorDto;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorDetailsDto;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorDto;

@Mapper(componentModel = "spring")
public interface RegistrationSensorMapper {

    RegistrationSensorDto toDto(SensorDto sensorDto, SensorDetailsDto details);

    SensorDto toSensorDto(RegistrationSensorDto dto);

    @Mapping(target = "model", source = "dto.details.model")
    @Mapping(target = "description", source = "dto.details.description")
    SensorDetailsDto toSensorDetailDto (RegistrationSensorDto dto);

}
