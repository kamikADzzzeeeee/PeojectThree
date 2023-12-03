package ru.yamshikov.rest.api.projectthree.util.validations;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import ru.yamshikov.rest.api.projectthree.dto.sensor.RegistrationSensorDto;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorNotCreatedException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationSensorDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationSensorDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            List<String> stringErrors = new ArrayList<>();
            List<FieldError> fieldErrorList = errors.getFieldErrors();
            for (FieldError error : fieldErrorList){
                StringBuilder result = new StringBuilder();
                result.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage());
                stringErrors.add(result.toString());
            }
            throw new SensorNotCreatedException("Ошибка валидации при создании датчика", stringErrors);
        }
    }
}
