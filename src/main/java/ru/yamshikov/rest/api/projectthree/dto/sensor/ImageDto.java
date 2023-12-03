package ru.yamshikov.rest.api.projectthree.dto.sensor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Транспортная сущность информации при получении изображения графика температуры")
public class ImageDto {

    @Schema(description = "Изображение графика температуры в строковом виде (Base 64)",
            example = "iVBORw0KGgoAAAANSUhEUgAAAfAAAA")
    String image;

}
