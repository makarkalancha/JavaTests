package com.everything.design_patterns.headfirst.observer.not_java_native;

import com.everything.design_patterns.headfirst.observer.not_java_native.subject.WeatherData;

/**
 * User: Makar Kalancha
 * Date: 29/07/14
 * Time: 2:02 PM
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);
    }
}
