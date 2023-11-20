package ru.yamshikov.rest.api.projectthree.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.yamshikov.rest.api.projectthree.mapper.MeasurementMapper;
import ru.yamshikov.rest.api.projectthree.mapper.MeasurementSensorMapper;
import ru.yamshikov.rest.api.projectthree.mapper.SensorMapper;
import ru.yamshikov.rest.api.projectthree.models.Measurement;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractDto;

import java.time.LocalDateTime;

@Data
public class MeasurementSensorDtoIn implements AbstractDto {

    @Min(value = -100, message = "Температура не должна быть ниже минус 100 °C")
    @Max(value = 100, message = "Температура не должна быть выше 100 °C")
    @NotNull(message = "Поле не должно быть null")
    @Digits(message = "Поле не должно содержать символов", integer = 4, fraction = 0)
    //@NotEmpty(message = "Поле не должно быть пустым")
    private Integer temperature;

    @Min(value = 0, message = "Влажность не должна быть ниже 0 %")
    @Max(value = 100, message = "Влажность не должна быть выше 100 %")
    @NotNull(message = "Поле не должно быть null")
    //@NotEmpty(message = "Поле не должно быть пустым")
    private Integer humidity;

    @NotBlank(message = "Поле не должно быть пустым или null")
    //@NotEmpty(message = "Поле не должно быть пустым")
    private String weather;

    @Valid
    private SensorDtoInOut sensor;


    public static Measurement toMeasurement(MeasurementSensorDtoIn dtoInfo, MeasurementSensorMapper measurementSensorMapper, SensorMapper sensorMapper, MeasurementMapper measurementMapper){
            Measurement measurement = measurementMapper.toEntity(measurementSensorMapper.toEntity(dtoInfo));
            measurement.setSensor(sensorMapper.toEntity(dtoInfo.getSensor()));
            return measurement;
    }


}
