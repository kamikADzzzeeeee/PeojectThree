package ru.yamshikov.rest.api.projectthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.yamshikov.rest.api.projectthree.models.Measurement;
import ru.yamshikov.rest.api.projectthree.models.Sensor;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {

    //для проблемы N + 1 HQL запрос
    @Query(value = "select s from Sensor s join fetch s.measurements")
    List<Sensor> findAllMeasurementWithSensor();

    List<Measurement> findByWeatherEquals(String meather);

    List<Measurement> findBySensorEquals(Sensor sensor);

}
