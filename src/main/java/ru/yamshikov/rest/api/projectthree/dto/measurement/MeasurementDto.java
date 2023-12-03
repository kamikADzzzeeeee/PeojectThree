package ru.yamshikov.rest.api.projectthree.dto.measurement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспортная сущность информации при получении измерения")
public class MeasurementDto  {

    @Schema(description = "Температура", examples = {"27", "-5", "32"})
    private Integer temperature;

    @Schema(description = "Влажность", examples = {"80", "5", "25"})
    private Integer humidity;

    @Schema(description = "Погода", examples = {"SUN", "RAIN", "FROG"})
    private String weather;

    @Schema(description = "Дата и время", examples = {
            "2023-11-21T22:10:33.14343",
            "2023-11-21T22:10:38.628112",
            "2023-11-21T22:10:46.195913"})
    private LocalDateTime registratedAt;

}