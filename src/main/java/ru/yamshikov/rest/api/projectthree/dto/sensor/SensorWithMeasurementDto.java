package ru.yamshikov.rest.api.projectthree.dto.sensor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.yamshikov.rest.api.projectthree.dto.measurement.MeasurementDto;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorWithMeasurementDto {

    private Integer id;

    @Size(min = 0, max = 50, message = "Поле должно содержать от 0 до 50 символов")
    private String name;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 1, message = "Поле должно быть больше 0")
    private Long serialNumber;

    @Valid
    @NotNull(message = "Поле не должно быть пустым")
    List<MeasurementDto> measurements;

}
