package ru.yamshikov.rest.api.projectthree.util.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.EmptySensorListException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(EmptySensorListException.class)
    public ResponseEntity<SensorErrorResponse> handleException(EmptySensorListException e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        SensorErrorResponse response = new SensorErrorResponse("Список датчиков пуст", dtf.format(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
