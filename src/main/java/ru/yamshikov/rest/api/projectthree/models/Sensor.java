package ru.yamshikov.rest.api.projectthree.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import ru.yamshikov.rest.api.projectthree.util.mapper.AbstractEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Sensor")
@Data
@ToString(of = {"id", "name", "serialNumber", "registratedAt"})
public class Sensor implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Integer id;

    @Column(name = "name")
    @Size(min = 0, max = 50, message = "Поле должно должно содержать от 0 до 50 символов")
    private String name;

    @Column(name = "serial_number")
    @Min(value = 0, message = "Серийный номера датчика должен быть больше 0")
    private Integer serialNumber;

    @Column(name = "created_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate registratedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", referencedColumnName = "model_id")
    private SensorDetails details;

    @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY)
    private List<Measurement> measurements;

    @PrePersist
    public void toRegistrated(){
        this.registratedAt = LocalDate.now();
    }

}
