package ru.yamshikov.rest.api.projectthree.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.yamshikov.rest.api.projectthree.dto.measurement.RegistrationMeasurementDto;
import ru.yamshikov.rest.api.projectthree.dto.measurement.WeatherDaysCountDtoOut;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorWithMeasurementDto;
import ru.yamshikov.rest.api.projectthree.mappers.sensor.SetSensorMapper;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.services.MeasurementService;
import ru.yamshikov.rest.api.projectthree.util.errors.ErrorResponse;
import ru.yamshikov.rest.api.projectthree.util.validations.RegistrationMeasurementDtoValidation;

import java.util.Set;

@RestController
@RequestMapping("/api/measurements")
@AllArgsConstructor
@Tag(name = "Операции с измерениями")
public class MeasurementController {

    private final RegistrationMeasurementDtoValidation measurementDtoValidation;
    private final MeasurementService measurementService;

    private final SetSensorMapper setSensorMapper;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK. Список измерений у каждого датчика",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = SensorWithMeasurementDto.class)))}),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND. Попытка получить список измерений при их отсутствии",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))})})
    @Operation(summary = "Получить список всех измерений каждого датчика")
    @GetMapping()
    public ResponseEntity<Set<SensorWithMeasurementDto>> measurementsPage() {
        Set<Sensor> setSensor = measurementService.findAllMeasurement();
        Set<SensorWithMeasurementDto> setSensorsDto = setSensorMapper.toDto(setSensor);
        return new ResponseEntity<>(
                setSensorsDto,
                HttpStatus.OK);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED. Измерение добавлено"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST. Ошибка валидации при добавлении измерения",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "409", description = "CONFLICT. Добавление измерения к незарегистрированному датчику",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))})})
    @Operation(summary = "Добавить новое измерение")
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addPage(@RequestBody @Valid RegistrationMeasurementDto dto, BindingResult bindingResult) {
        //Валидация DTO
        measurementDtoValidation.validate(dto, bindingResult);
        //Внесение в БД
        measurementService.registrationMeasurement(dto);
        //Ответ
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK. Количество дней",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = WeatherDaysCountDtoOut.class))}),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND. Попытка получить список измерений при их отсутствии",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))})})
    @Operation(summary = "Получить общее количество дней по типу погоды")
    @GetMapping("/DaysCountWhereWeather")
    public ResponseEntity<WeatherDaysCountDtoOut> daysCountWhereWeather(
            @Parameter(
                    description = "Тип погоды",
                    examples = {@ExampleObject(name = "RAIN"),
                            @ExampleObject(name = "SUN"),
                            @ExampleObject(name = "FROG")})
            @RequestParam(name = "weather", required = true) String weather) {
        int countDays = measurementService.getCountAllWeatherDays(weather);
        return new ResponseEntity<>(new WeatherDaysCountDtoOut(countDays), HttpStatus.OK);
    }


}
