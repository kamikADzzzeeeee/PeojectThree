package ru.yamshikov.rest.api.projectthree.dto.measurement;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспортная сущность информации при регистрации измерения")
public class RegistrationMeasurementDto {

    @Min(value = -100, message = "Температура не должна быть ниже минус 100 °C")
    @Max(value = 100, message = "Температура не должна быть выше 100 °C")
    @NotNull(message = "Поле не должно быть null")
    @Schema(description = "Температура", examples = {"27", "-5", "32"})
    private Integer temperature;

    @Min(value = 0, message = "Влажность не должна быть ниже 0 %")
    @Max(value = 100, message = "Влажность не должна быть выше 100 %")
    @NotNull(message = "Поле не должно быть null")
    @Schema(description = "Влажность", examples = {"80", "5", "25"})
    private Integer humidity;

    @NotBlank(message = "Поле не должно быть пустым или null")
    @Schema(description = "Погода", examples = {"SUN", "RAIN", "FROG"})
    private String weather;

    @Valid
    @NotNull(message = "Поле не должно быть null")
    @Schema(description = "Транспортная сущность информации при регистрации датчика")
    private SensorDto sensor;

}
