package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    private Map<String, Double> temperaturesMap;
    WeatherForecast weatherForecast;

    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    void initializeTestInput() {
        temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow",25.5);
        temperaturesMap.put("Krakow",26.2);
        temperaturesMap.put("Wroclaw",24.8);
        temperaturesMap.put("Warszawa",25.2);
        temperaturesMap.put("Gdansk",26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    void testCalculateForecastWithMock() {
        //Given
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateTheAverageTemperatureWithMock() {
        //Given
        //When
        double theAverageTemperature = weatherForecast.calculateTheAverageTemperature();
        //Then
        Assertions.assertEquals(25.56, theAverageTemperature);
    }

    @Test
    void testCalculateTheMedianTemperatureWithMock() {
        //Given
        //When
        double theMedianTemperature = weatherForecast.calculateTheMedianTemperature();
        //Then
        Assertions.assertEquals(25.5, theMedianTemperature);
    }
}