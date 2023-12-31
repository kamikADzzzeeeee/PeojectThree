CREATE TABLE Sensor_info (
    model_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    model_name varchar(16),
    model_description varchar(255)
);
CREATE TABLE Sensor (
    sensor_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(50),
    serial_number int CHECK (serial_number > 0),
    model_id int REFERENCES Sensor_info(model_id),
    created_at date NOT NULL
);
CREATE TABLE Measurement (
    measurement_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    sensor_id int REFERENCES Sensor(sensor_id),
    temperature int NOT NULL CHECK(temperature BETWEEN -100 AND 100),
    humidity int NOT NULL CHECK(humidity BETWEEN 0 AND 100),
    weather varchar(20) NOT NULL,
    registrated_at timestamp
);

DROP TABLE Measurement;
DROP TABLE Sensor;
DROP TABLE Sensor_info;

