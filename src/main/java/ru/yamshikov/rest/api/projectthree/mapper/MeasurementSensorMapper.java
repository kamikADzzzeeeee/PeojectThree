package ru.yamshikov.rest.api.projectthree.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yamshikov.rest.api.projectthree.dto.MeasurementDtoOut;
import ru.yamshikov.rest.api.projectthree.dto.MeasurementSensorDtoIn;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractMapper;

@Component
public class MeasurementSensorMapper extends AbstractMapper<MeasurementDtoOut, MeasurementSensorDtoIn> {

    @Autowired
    public MeasurementSensorMapper() {
        super(MeasurementDtoOut.class, MeasurementSensorDtoIn.class);
    }

}
