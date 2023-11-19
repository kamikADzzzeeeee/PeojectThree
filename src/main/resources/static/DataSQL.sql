INSERT INTO Sensor_info (model, description)
VALUES ('K700','Модель К700. Производства 1970 г. Страна: СССР');
INSERT INTO Sensor_info (model, description)
VALUES ('K800','Модель К800. Производства 1980 г. Страна: СССР');
INSERT INTO Sensor_info (model, description)
VALUES ('K900','Модель К900. Производства 1990 г. Страна: СССР');
INSERT INTO Sensor_info (model, description)
VALUES ('K020','Модель К020. Производства 2000 г. Страна: РФ');
INSERT INTO Sensor_info (model, description)
VALUES ('A100','Модель А100. Производства 2011 г. Страна: РФ. Производительнее на 40%');
INSERT INTO Sensor_info (model, description)
VALUES ('A200','Модель A200. Производства 2020 г. Страна: РФ/Япония');
--
INSERT INTO Sensor (name, serial_number, model, created_at)
VALUES('ONE',12345601,'K700','15/09/2019');
INSERT INTO Sensor (name, serial_number, model, created_at)
VALUES('TWO',12345603,'K700','16/10/2019');
INSERT INTO Sensor (name, serial_number, model, created_at)
VALUES('THREE',12345608,'K800','01/10/2021');
--
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 27, 20, 'SUN', '01/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 28, 20, 'SUN', '02/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 30, 20, 'SUN', '03/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 35, 20, 'SUN', '04/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 20, 20, 'SUN', '05/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 18, 20, 'RAIN', '06/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 17, 20, 'RAIN', '07/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 25, 20, 'SUN', '08/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 27, 20, 'SUN', '09/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 25, 20, 'SUN', '10/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 26, 20, 'SUN', '11/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 25, 20, 'SUN', '12/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 27, 20, 'SUN', '13/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 23, 20, 'RAIN', '14/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 25, 20, 'SUN', '15/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345601, 25, 20, 'SUN', '16/10/2019');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 27, 20, 'SUN', '01/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 28, 20, 'SUN', '02/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 30, 20, 'SUN', '03/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 35, 20, 'SUN', '05/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 20, 20, 'SUN', '08/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 18, 20, 'RAIN', '10/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 17, 20, 'RAIN', '12/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 25, 20, 'SUN', '14/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 27, 20, 'SUN', '16/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 25, 20, 'SUN', '19/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 26, 20, 'SUN', '22/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 25, 20, 'SUN', '28/10/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 27, 20, 'SUN', '05/11/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 23, 20, 'RAIN', '10/11/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 25, 20, 'SUN', '20/11/2021');
INSERT INTO Measurement (serial_number_sensor, temperature, humidity, weather, registrated_at)
VALUES(12345608, 25, 20, 'SUN', '28/11/2021');
