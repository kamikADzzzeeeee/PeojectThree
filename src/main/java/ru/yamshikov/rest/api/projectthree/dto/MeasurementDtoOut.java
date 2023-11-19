package ru.yamshikov.rest.api.projectthree.dto;

import lombok.Data;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractDto;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractEntity;

import java.time.LocalDateTime;

@Data
public class MeasurementDtoOut implements AbstractDto, AbstractEntity {

    private int temperature;

    private int humidity;

    private String weather;

    private LocalDateTime registratedAt;

}
