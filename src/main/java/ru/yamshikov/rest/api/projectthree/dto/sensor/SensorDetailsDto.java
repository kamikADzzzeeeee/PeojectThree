package ru.yamshikov.rest.api.projectthree.dto.sensor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDetailsDto {

    @NotNull(message = "Поле не должно быть null")
    @Size(min = 0, max = 16, message = "Поле должно содержать от 0 до 16 символов")
    private String model;

    @NotNull(message = "Поле не должно быть null")
    @Size(min = 0, max = 255, message = "Поле должно содержать от 0 до 255 символов")
    private String description;

}
