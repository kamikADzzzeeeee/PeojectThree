package ru.yamshikov.rest.api.projectthree.dto.sensor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SensorDtoInfo {
    private String name;
    @NotEmpty(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Поле должно быть больше 0")
    private Integer serialNumber;
}
