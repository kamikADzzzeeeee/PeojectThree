package ru.yamshikov.rest.api.projectthree.util.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Schema(description = "Транспортная сущность информации при получении ошибки")
@Data
@AllArgsConstructor

public class ErrorResponse {
    @Schema(description = "Сообщение об ошибке",
            example = "Ошибка по причине ...")

    private String message;

    @Schema(description = "Список ошибок")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    @Schema(description = "Дата/время",
            example = "23.11.2023 00:23:05")
    private String timestamp;

    public ErrorResponse(String message, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
