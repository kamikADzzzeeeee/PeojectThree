package ru.yamshikov.rest.api.projectthree.services;

import lombok.AllArgsConstructor;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yamshikov.rest.api.projectthree.dto.sensor.RegistrationSensorDto;
import ru.yamshikov.rest.api.projectthree.dto.sensor.SensorWithDetailsDto;
import ru.yamshikov.rest.api.projectthree.mappers.sensor.RegistrationSensorMapper;
import ru.yamshikov.rest.api.projectthree.mappers.sensor.SensorDetailsMapper;
import ru.yamshikov.rest.api.projectthree.mappers.sensor.SensorMapper;
import ru.yamshikov.rest.api.projectthree.mappers.sensor.SensorWithDetailMapper;
import ru.yamshikov.rest.api.projectthree.models.Measurement;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.models.SensorDetails;
import ru.yamshikov.rest.api.projectthree.repositories.MeasurementRepository;
import ru.yamshikov.rest.api.projectthree.repositories.SensorRepository;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.measurement.EmptyMeasurementListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.EmptySensorListException;
import ru.yamshikov.rest.api.projectthree.util.errors.exceptions.sensor.SensorAlreadyExistsException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final MeasurementRepository measurementRepository;
    private final SensorMapper sensorMapper;
    private final RegistrationSensorMapper registrationSensorMapper;
    private final SensorDetailsMapper sensorDetailsMapper;
    private final SensorWithDetailMapper sensorWithDetailMapper;

//    @Transactional(/*readOnly = true*/)
    public List<SensorWithDetailsDto> findAllSensors() {
        List<Sensor> sensors = sensorRepository.findAll();
        if (sensors.isEmpty()){
            throw new EmptySensorListException();
        }
        List<SensorWithDetailsDto> sensorsDto = new ArrayList<>();
        for (Sensor sensor : sensors){
            sensorsDto.add(
                    sensorWithDetailMapper.toDto(
                            sensorMapper.toDto(sensor),
                            sensorDetailsMapper.toDto(sensor.getDetails())
                    )
            );
        }
        return sensorsDto;
    }

    @Transactional(readOnly = false)
    public void createdSensor(RegistrationSensorDto registrationDto) {
        Sensor sensor = sensorMapper.toEntity(registrationSensorMapper.toSensorDto(registrationDto));
        SensorDetails details = sensorDetailsMapper.toEntity(registrationDto.getDetails());
        sensor.setDetails(details);
        sensorRepository.findBySerialNumber(sensor.getSerialNumber()).ifPresent(action -> {
            throw new SensorAlreadyExistsException();
        });
        sensorRepository.save(sensor);
    }

    @Transactional(readOnly = true)
    public List<Measurement> findSensorWithMeasurementById(int id) {
        Sensor sensor = new Sensor();
        sensor.setId(id);
        List<Measurement> measurements = measurementRepository.findBySensorEquals(sensor);
        if (measurements.isEmpty()) {
            throw new EmptyMeasurementListException();
        }
        return measurements;
    }

    //Создаем изображение графика температуры на основе данных из БД
    public XYChart measurementToXYChart(List<Measurement> measurements) {
        List<Integer> temperatures = new ArrayList<>();
        List<Long> longs = new ArrayList<>();

        long i = 0;
        for (Measurement measurement : measurements) {
            temperatures.add(measurement.getTemperature());
            longs.add(i);
            i++;
        }

        XYChart chart = new XYChartBuilder()
                .width(1200).height(600)
                .title("Температура")
                .yAxisTitle("Градусы, °C")
                .build();
        chart.addSeries(" ", longs, temperatures);

        LocalDateTime from = measurements.get(0).getRegistratedAt();
        LocalDateTime to = measurements.get(measurements.size() - 1).getRegistratedAt();
        long betweenFromAndTo = ChronoUnit.HOURS.between(from, to);

        DateTimeFormatter dtf;
        if (betweenFromAndTo <= 24) {
            dtf = DateTimeFormatter.ofPattern("HH:mm");
            chart.setXAxisTitle("Время, часы");
        } else {
            dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            chart.setXAxisTitle("Время, дни");
        }
        Function<Double, String> function = inDouble -> dtf.format(
                measurements
                    .get(inDouble.intValue())
                    .getRegistratedAt());

        chart.setCustomXAxisTickLabelsFormatter(function);
        return chart;
    }

    //Переводим изображения графика в строковое представление
    public String xyChartToStringBase64(XYChart chart) {
        byte[] charBytes;
        try {
            charBytes = BitmapEncoder.getBitmapBytes(chart, BitmapEncoder.BitmapFormat.PNG);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return Base64.getEncoder().encodeToString(charBytes);
    }


}
