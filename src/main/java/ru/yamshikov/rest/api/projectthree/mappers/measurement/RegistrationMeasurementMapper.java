package ru.yamshikov.rest.api.projectthree.mappers.measurement;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.yamshikov.rest.api.projectthree.dto.measurement.MeasurementDto;
import ru.yamshikov.rest.api.projectthree.dto.measurement.RegistrationMeasurementDto;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorDto;

@Mapper(componentModel = "spring")
public interface RegistrationMeasurementMapper {
    RegistrationMeasurementDto toDto(MeasurementDto measurement, SensorDto sensor);

    @Mapping(target = "id", source = "dto.sensor.id")
    @Mapping(target = "name", source = "dto.sensor.name")
    @Mapping(target = "serialNumber", source = "dto.sensor.serialNumber")
    SensorDto toSensorDto(RegistrationMeasurementDto dto);


    MeasurementDto toMeasurementDto(RegistrationMeasurementDto dto);


}
