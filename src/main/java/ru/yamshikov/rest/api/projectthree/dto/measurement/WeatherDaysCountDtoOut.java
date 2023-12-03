package ru.yamshikov.rest.api.projectthree.dto.measurement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Транспортная сущность информации при получении количества дней по погоде")
public class WeatherDaysCountDtoOut {

    @Schema(description = "Количество дней")
    private Integer countDays;

}
