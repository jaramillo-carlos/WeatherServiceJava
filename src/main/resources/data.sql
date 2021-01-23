INSERT INTO LOCATION(id, lat, lon, city, state) VALUES (1, 100.1, 100.1, 'Medellin', 'ANT');
INSERT INTO LOCATION(id, lat, lon, city, state) VALUES (2, 0.1, 0.1, 'Bogota', 'BOG');
INSERT INTO LOCATION(id, lat, lon, city, state) VALUES (3, 3.1, 7.9, 'Cali', 'BOG');
INSERT INTO LOCATION(id, lat, lon, city, state) VALUES (4, 5.2, 8.1, 'Cartagena', 'BOG');
INSERT INTO LOCATION(id, lat, lon, city, state) VALUES (5, 10.1, 10.5, 'Santa Marta', 'BOG');

INSERT INTO WEATHER_DATA(id, date, location_id) VALUES (1, '2020-10-10', 1);
INSERT INTO WEATHER_DATA(id, date, location_id) VALUES (2, '2020-10-10', 2);
INSERT INTO WEATHER_DATA(id, date, location_id) VALUES (3, '2020-10-10', 3);
INSERT INTO WEATHER_DATA(id, date, location_id) VALUES (4, '2020-10-10', 4);
INSERT INTO WEATHER_DATA(id, date, location_id) VALUES (5, '2020-10-10', 5);

INSERT INTO WEATHER_DATA_TEMPERATURES(weather_data_id, temperature) VALUES (1, 23.5);
INSERT INTO WEATHER_DATA_TEMPERATURES(weather_data_id, temperature) VALUES (2, 25.7);
INSERT INTO WEATHER_DATA_TEMPERATURES(weather_data_id, temperature) VALUES (3, 32.1);
INSERT INTO WEATHER_DATA_TEMPERATURES(weather_data_id, temperature) VALUES (4, 35.5);
INSERT INTO WEATHER_DATA_TEMPERATURES(weather_data_id, temperature) VALUES (5, 28.9);