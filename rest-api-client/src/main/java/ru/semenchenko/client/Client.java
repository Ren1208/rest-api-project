package ru.semenchenko.client;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.semenchenko.client.dto.MeasurementDTO;
import ru.semenchenko.client.dto.MeasurementsResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Artyom Semenchenko
 */

public class Client {
    private static final String SENSOR_REGISTRATION_URL = "http://localhost:8080/sensors/registration";
    private static final String ADD_MEASUREMENT_URL = "http://localhost:8080/measurements/add";
    private static final String GET_ALL_MEASUREMENTS_URL = "http://localhost:8080/measurements";
    private static final double MIN_TEMPERATURE = -70.0;
    private static final double MAX_TEMPERATURE = 50.0;
    private static final String SENSOR_NAME = "Sensor";
    private static final int MEASUREMENTS_COUNT = 100;

    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {

        // Регистрация сенсора и отправка измерений на сервер

        registerSensor(SENSOR_NAME);

        Random random = new Random();

        for (int i = 0; i < MEASUREMENTS_COUNT; i++) {
            System.out.println(i);
            double temperature = random.nextDouble() * (MAX_TEMPERATURE - MIN_TEMPERATURE) + MIN_TEMPERATURE;
            sendMeasurement(temperature, random.nextBoolean(), SENSOR_NAME);
        }

        // Получение измерений с сервера

        MeasurementsResponse response = getAllMeasurements();
        if (response != null) {
            List<MeasurementDTO> measurements = response.getMeasurements();
            System.out.println("Получено измерений: " + measurements.size());
            measurements.forEach(m -> System.out.println(
                    "Температура: " + m.getValue() +
                            ", Дождь: " + m.getRaining() +
                            ", Датчик: " + m.getSensor().getName()
            ));
        }
    }

    public static void registerSensor(String sensorName) {
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("name", sensorName);

        sendPostRequest(SENSOR_REGISTRATION_URL, jsonData);
    }

    public static void sendMeasurement(double value, boolean raining, String sensorName) {
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("value", value);
        jsonData.put("raining", raining);
        jsonData.put("sensor", Map.of("name", sensorName));

        sendPostRequest(ADD_MEASUREMENT_URL, jsonData);
    }

    public static void sendPostRequest(String url, Map<String, Object> jsonData) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonData, headers);

        try {
            restTemplate.postForObject(url, request, String.class);
            System.out.println("Данные успешно отправлены на сервер!");
        } catch (HttpClientErrorException e) {
            System.out.println("ОШИБКА!");
            System.out.println(e.getMessage());
        }
    }

    public static MeasurementsResponse getAllMeasurements() {
        try {
            return restTemplate.getForObject(GET_ALL_MEASUREMENTS_URL, MeasurementsResponse.class);
        } catch (HttpClientErrorException e) {
            System.out.println("Ошибка при получении данных: " + e.getMessage());
            return null;
        }
    }
}
