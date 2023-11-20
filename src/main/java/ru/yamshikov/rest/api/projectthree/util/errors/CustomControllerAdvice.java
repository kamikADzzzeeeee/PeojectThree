package ru.yamshikov.rest.api.projectthree.util.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.measurement.EmptyMeasurementListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.measurement.MeasurementNotRegistratedException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.EmptySensorListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorAlreadyExistsException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorNotCreatedException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorNotRegistratedException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(EmptySensorListException.class)
    public ResponseEntity<ErrorResponse> handleException(EmptySensorListException e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        ErrorResponse response = new ErrorResponse("Список датчиков пуст", dtf.format(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SensorNotCreatedException.class)
    public ResponseEntity<ErrorResponse> handleException(SensorNotCreatedException e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        ErrorResponse response = new ErrorResponse(e.getMessage(), dtf.format(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SensorAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleException(SensorAlreadyExistsException e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        ErrorResponse response = new ErrorResponse("Датчик с таким серйным номером уже существует", dtf.format(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SensorNotRegistratedException.class)
    public ResponseEntity<ErrorResponse> handleException(SensorNotRegistratedException e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        ErrorResponse response = new ErrorResponse("Невозможно добавить измерение т.к. датчик не зарегестрирован", dtf.format(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //----------------//

    @ExceptionHandler(MeasurementNotRegistratedException.class)
    public ResponseEntity<ErrorResponse> handleException(MeasurementNotRegistratedException e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        ErrorResponse response = new ErrorResponse(e.getMessage(), dtf.format(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyMeasurementListException.class)
    public ResponseEntity<ErrorResponse> handleException(EmptyMeasurementListException e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        ErrorResponse response = new ErrorResponse("Список измерений пуст", dtf.format(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
