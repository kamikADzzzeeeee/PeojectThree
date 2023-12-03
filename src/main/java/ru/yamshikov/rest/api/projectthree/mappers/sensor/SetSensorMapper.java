package ru.yamshikov.rest.api.projectthree.mappers.sensor;

import org.mapstruct.Mapper;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorWithMeasurementDto;
import ru.yamshikov.rest.api.projectthree.models.Sensor;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface SetSensorMapper {

    Set<SensorWithMeasurementDto> toDto(Set<Sensor> sensors);

}
