package ru.yamshikov.rest.api.projectthree.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.yamshikov.rest.api.projectthree.mapper.MeasurementMapper;
import ru.yamshikov.rest.api.projectthree.mapper.SensorMapper;
import ru.yamshikov.rest.api.projectthree.models.Measurement;
import ru.yamshikov.rest.api.projectthree.models.Sensor;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorListMeasurementsDtoOut implements AbstractDto {
    private SensorDtoInOut sensor;
    private List<MeasurementDtoOut> measurements;


    public static Set<SensorListMeasurementsDtoOut> toSet(Set<Sensor> setSensor, MeasurementMapper measurementMapper, SensorMapper sensorMapper){
        Set<SensorListMeasurementsDtoOut> setSenMeasDto = new HashSet<>();
        for(Sensor sensor : setSensor){
            List<MeasurementDtoOut> listMeasurementDto = new ArrayList<>();
            for (Measurement measurement : sensor.getMeasurements()){
                listMeasurementDto.add(measurementMapper.toDto(measurement));
            }
            SensorListMeasurementsDtoOut sensorMeasurementDto = new SensorListMeasurementsDtoOut();
            sensorMeasurementDto.setSensor(sensorMapper.toDto(sensor));
            sensorMeasurementDto.setMeasurements(listMeasurementDto);
            setSenMeasDto.add(sensorMeasurementDto);
        }
        return setSenMeasDto;
    }

}
