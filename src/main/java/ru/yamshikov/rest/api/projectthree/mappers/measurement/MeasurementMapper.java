package ru.yamshikov.rest.api.projectthree.mappers.measurement;


import org.mapstruct.Mapper;
import ru.yamshikov.rest.api.projectthree.dto.measurement.MeasurementDto;
import ru.yamshikov.rest.api.projectthree.models.Measurement;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {

    MeasurementDto toDto(Measurement measurement);

    Measurement toEntity(MeasurementDto dto);

}
