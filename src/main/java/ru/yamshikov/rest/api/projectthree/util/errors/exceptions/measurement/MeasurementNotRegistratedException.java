package ru.yamshikov.rest.api.projectthree.util.errors.exceptions.measurement;

import lombok.Getter;

import java.util.List;

public class MeasurementNotRegistratedException extends RuntimeException{

    @Getter
    private final List<String> errors;

    public MeasurementNotRegistratedException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }
}
