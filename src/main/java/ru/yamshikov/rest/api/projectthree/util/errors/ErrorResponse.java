package ru.yamshikov.rest.api.projectthree.util.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private String timestamp;
}
