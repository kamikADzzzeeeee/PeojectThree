package ru.yamshikov.rest.api.projectthree.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yamshikov.rest.api.projectthree.dto.MeasurementDtoOut;
import ru.yamshikov.rest.api.projectthree.models.Measurement;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractMapper;

@Component
public class MeasurementMapper extends AbstractMapper<Measurement, MeasurementDtoOut> {
    @Autowired
    public MeasurementMapper() {
        super(Measurement.class, MeasurementDtoOut.class);
    }
}
