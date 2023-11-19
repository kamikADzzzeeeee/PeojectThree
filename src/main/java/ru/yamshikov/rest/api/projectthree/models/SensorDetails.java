package ru.yamshikov.rest.api.projectthree.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Sensor_info")
@Data
@ToString(of = {"id", "model", "description"})
public class SensorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer id;

    @Column(name = "model_name")
    @Size(min = 0, max = 16, message = "Поле должно содержать от 0 до 16 символов")
    private String model;

    @Column(name = "model_description")
    @Size(min = 0, max = 255, message = "Поле должно содержать от 0 до 255 символов")
    private String description;

    @OneToMany(mappedBy = "details", fetch = FetchType.LAZY)
    private List<Sensor> sensors;
}
