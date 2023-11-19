INSERT INTO Sensor_info (model_name, model_description)
VALUES ('K700','Модель К700. Производства 1970 г. Страна: СССР');
INSERT INTO Sensor_info (model_name, model_description)
VALUES ('K800','Модель К800. Производства 1980 г. Страна: СССР');
INSERT INTO Sensor_info (model_name, model_description)
VALUES ('K900','Модель К900. Производства 1990 г. Страна: СССР');
INSERT INTO Sensor_info (model_name, model_description)
VALUES ('K020','Модель К020. Производства 2000 г. Страна: РФ');
INSERT INTO Sensor_info (model_name, model_description)
VALUES ('A100','Модель А100. Производства 2011 г. Страна: РФ. Производительнее на 40%');
INSERT INTO Sensor_info (model_name, model_description)
VALUES ('A200','Модель A200. Производства 2020 г. Страна: РФ/Япония');
--
INSERT INTO Sensor (name, serial_number, model_id, created_at)
VALUES('ONE',12345601,1,'15/09/2019');
INSERT INTO Sensor (name, serial_number, model_id, created_at)
VALUES('TWO',12345603,1,'16/10/2019');
INSERT INTO Sensor (name, serial_number, model_id, created_at)
VALUES('THREE',12345608,2,'01/10/2021');
INSERT INTO Sensor (serial_number, created_at)
VALUES(12345611,'02/11/2022');
--
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 27, 20, 'SUN', '01/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 28, 20, 'SUN', '02/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 30, 20, 'SUN', '03/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 35, 20, 'SUN', '04/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 20, 20, 'SUN', '05/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 18, 20, 'RAIN', '06/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 17, 20, 'RAIN', '07/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 25, 20, 'SUN', '08/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 27, 20, 'SUN', '09/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 25, 20, 'SUN', '10/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 26, 20, 'SUN', '11/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 25, 20, 'SUN', '12/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 27, 20, 'SUN', '13/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 23, 20, 'RAIN', '14/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 25, 20, 'SUN', '15/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(2, 25, 20, 'SUN', '16/10/2019');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 27, 20, 'SUN', '01/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 28, 20, 'SUN', '02/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 30, 20, 'SUN', '03/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 35, 20, 'SUN', '05/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 20, 20, 'SUN', '08/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 18, 20, 'RAIN', '10/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 17, 20, 'RAIN', '12/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 25, 20, 'SUN', '14/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 27, 20, 'SUN', '16/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 25, 20, 'SUN', '19/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 26, 20, 'SUN', '22/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 25, 20, 'SUN', '28/10/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 27, 20, 'SUN', '05/11/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 23, 20, 'RAIN', '10/11/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 25, 20, 'SUN', '20/11/2021');
INSERT INTO Measurement (sensor_id, temperature, humidity, weather, registrated_at)
VALUES(3, 25, 20, 'SUN', '28/11/2021');
