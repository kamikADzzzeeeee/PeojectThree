package ru.yamshikov.rest.api.projectthree.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDtoInOut implements AbstractDto {
    @Size(min = 0, max = 50, message = "Поле должно содержать от 0 до 50 символов")
    private String name;
    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 1, message = "Поле должно быть больше 0")
    private Long serialNumber;
}
