package ru.yamshikov.rest.api.projectthree.util.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class SensorErrorResponse{
    private String message;
    private String timestamp;
}
