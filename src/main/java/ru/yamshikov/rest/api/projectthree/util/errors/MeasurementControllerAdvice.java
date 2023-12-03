package ru.yamshikov.rest.api.projectthree.util.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.yamshikov.rest.api.projectthree.controllers.MeasurementController;
import ru.yamshikov.rest.api.projectthree.controllers.SensorController;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.measurement.EmptyMeasurementListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.measurement.MeasurementNotRegistratedException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice(assignableTypes = {MeasurementController.class, SensorController.class})
public class MeasurementControllerAdvice {

    private static final String formatDateTime = "dd.MM.yyyy HH:mm:ss";

    private static String formatter(LocalDateTime localDateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatDateTime);
        return dtf.format(localDateTime);
    }

    @ExceptionHandler(MeasurementNotRegistratedException.class)
    protected ResponseEntity<ErrorResponse> handleException(MeasurementNotRegistratedException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage(), e.getErrors(), formatter(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyMeasurementListException.class)
    protected ResponseEntity<ErrorResponse> handleException(EmptyMeasurementListException e) {
        ErrorResponse response = new ErrorResponse("Список измерений пуст", formatter(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
