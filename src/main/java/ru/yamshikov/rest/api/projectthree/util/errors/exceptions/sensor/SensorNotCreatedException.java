package ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor;

import lombok.Getter;

import java.util.List;

public class SensorNotCreatedException extends RuntimeException{

    @Getter
    private final List<String> errors;

    public SensorNotCreatedException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }
}
