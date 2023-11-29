package ru.yamshikov.rest.api.projectthree.util.errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.yamshikov.rest.api.projectthree.controllers.MeasurementController;
import ru.yamshikov.rest.api.projectthree.controllers.SensorController;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.EmptySensorListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorAlreadyExistsException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorNotCreatedException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorNotRegistratedException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice(assignableTypes = {MeasurementController.class, SensorController.class})
public class SensorControllerAdvice extends ResponseEntityExceptionHandler {

    private static final String formatDateTime = "dd.MM.yyyy HH:mm:ss";

    private static String formatter(LocalDateTime localDateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatDateTime);
        return dtf.format(localDateTime);
    }

    @ExceptionHandler(EmptySensorListException.class)
    protected ResponseEntity<ErrorResponse> handleException(EmptySensorListException e) {
        ErrorResponse response = new ErrorResponse(
                "Список датчиков пуст",
                formatter(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({SensorNotCreatedException.class, IllegalArgumentException.class})
    protected ResponseEntity<ErrorResponse> handleException(SensorNotCreatedException e) {
        ErrorResponse response = new ErrorResponse(
                e.getMessage(),
                e.getErrors(),
                formatter(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SensorAlreadyExistsException.class)
    protected ResponseEntity<ErrorResponse> handleException(SensorAlreadyExistsException e) {
        ErrorResponse response = new ErrorResponse(
                "Датчик с таким серйным номером уже существует",
                formatter(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(SensorNotRegistratedException.class)
    protected ResponseEntity<ErrorResponse> handleException(SensorNotRegistratedException e) {
        ErrorResponse response = new ErrorResponse(
                "Невозможно добавить измерение т.к. датчик не зарегестрирован",
                formatter(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                "Неверный формат JSON. Информация: " + ex.getLocalizedMessage(),
                formatter(LocalDateTime.now()));
        return new ResponseEntity<>(response, status);
    }

}
