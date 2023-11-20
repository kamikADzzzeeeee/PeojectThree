package ru.yamshikov.rest.api.projectthree.util.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.EmptySensorListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.SensorAlreadyExistsException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.SensorNotCreatedException;

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

    @ExceptionHandler(SensorNotCreatedException.class)
    public ResponseEntity<SensorErrorResponse> handleException(SensorNotCreatedException e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage(), dtf.format(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SensorAlreadyExistsException.class)
    public ResponseEntity<SensorErrorResponse> handleException(SensorAlreadyExistsException e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        SensorErrorResponse response = new SensorErrorResponse("Датчик с таким серйным номером уже существует", dtf.format(LocalDateTime.now()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
