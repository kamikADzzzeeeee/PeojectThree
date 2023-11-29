package ru.yamshikov.rest.api.projectthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.yamshikov.rest.api.projectthree.models.Sensor;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

    public Optional<Sensor> findBySerialNumber(long serialNumber);

    @Query(value = "select s from Sensor s left join fetch s.details d")
    public List<Sensor> findAllSensorsWithDetails();



}
