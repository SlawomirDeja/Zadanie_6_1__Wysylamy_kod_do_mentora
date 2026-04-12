package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateTheAverageTemperature() {
        double sum = 0;

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet())
            sum += temperature.getValue();

        return sum / temperatures.getTemperatures().size();
    }

    public double calculateTheMedianTemperature() {
        List<Double> temperaturesList = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temperaturesList);
        int size = temperaturesList.size();
        if (size % 2 == 0)
            return (temperaturesList.get(size / 2 - 1) + temperaturesList.get(size / 2)) / 2.0;
         else
            return temperaturesList.get(size / 2);
    }
}