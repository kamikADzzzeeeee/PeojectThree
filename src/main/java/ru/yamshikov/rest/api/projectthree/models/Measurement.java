package ru.yamshikov.rest.api.projectthree.models;


import jakarta.persistence.*;
import org.hibernate.annotations.CascadeType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
@Data
@ToString(of = {"id","temperature", "humidity", "weather", "registratedAt"})
@EqualsAndHashCode(of = {"id","temperature", "humidity", "weather", "registratedAt"})
public class Measurement implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private Integer id;

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "weather")
    private String weather;

    @Column(name = "registrated_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime registratedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    @Cascade(value = CascadeType.REMOVE)
    private Sensor sensor;

    @PrePersist
    public void toRegistrated(){
        this.registratedAt = LocalDateTime.now();
    }

}
