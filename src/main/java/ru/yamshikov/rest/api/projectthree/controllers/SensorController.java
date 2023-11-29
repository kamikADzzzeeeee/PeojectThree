package ru.yamshikov.rest.api.projectthree.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
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
import ru.yamshikov.rest.api.projectthree.dto.sensor.ImageDto;
import ru.yamshikov.rest.api.projectthree.dto.sensor.RegistrationSensorDto;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorWithDetailsDto;
import ru.yamshikov.rest.api.projectthree.util.validations.RegistrationSensorDtoValidator;
import ru.yamshikov.rest.api.projectthree.services.SensorService;
import ru.yamshikov.rest.api.projectthree.util.errors.ErrorResponse;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@AllArgsConstructor
@Tag(name = "Операции с датчиками")
public class SensorController {

    private SensorService sensorService;
    private final RegistrationSensorDtoValidator sensorValidator;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK. Список всех датчиков",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = SensorWithDetailsDto.class)))}),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND. Попытка получить список датчиков при их отсутствии",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) })})
    @GetMapping()
    @Operation(summary = "Получить список всех датчиков")
    public ResponseEntity<List<SensorWithDetailsDto>> sensorsPage(){
        List<SensorWithDetailsDto> sensorsDto = sensorService.findAllSensors();
        return new ResponseEntity<>(sensorsDto, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CREATED. Датчик зарегистрирован"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST. Ошибка валидации при регистрации датчика",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) }),
            @ApiResponse(responseCode = "409", description = "CONFLICT. Датчик с таким серйным номером уже существует",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) })})
    @PostMapping("/registration")
    @Operation(summary = "Добавить новый датчик")
    public ResponseEntity<HttpStatus> registrationPage(@RequestBody @Valid RegistrationSensorDto registrationDto,
                                                       BindingResult bindingResult){
        //Валидация DTO
        sensorValidator.validate(registrationDto, bindingResult);
        //Внесение в БД
        sensorService.createdSensor(registrationDto);
        //Ответ
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK. Изображение в Base64",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ImageDto.class))}),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND. Попытка получить список измерений при их отсутствии",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) })})
    @GetMapping("/{id}/image")
    @Operation(summary = "Получить строковое представление графика температуры датчика")
    public ResponseEntity<ImageDto> imageIdPage(
            @Parameter(description = "Уникальный идентификатор пользователя")
            @PathVariable(name = "id", required = true) Integer id){
        //Преобразование графика в String (Base64)
        String image = sensorService.xyChartToStringBase64(
                            sensorService.measurementToXYChart(
                                sensorService.findSensorWithMeasurementById(id)));
        //Ответ
        return new ResponseEntity<>(new ImageDto(image), HttpStatus.OK);
    }


}
