package ru.yamshikov.rest.api.projectthree.mappers.sensor;

import org.mapstruct.Mapper;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorDetailsDto;
import ru.yamshikov.rest.api.projectthree.models.SensorDetails;

@Mapper(componentModel = "spring")
public interface SensorDetailsMapper {

    SensorDetailsDto toDto(SensorDetails entity);

    SensorDetails toEntity(SensorDetailsDto dto);


}
