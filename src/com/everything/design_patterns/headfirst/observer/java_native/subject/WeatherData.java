package com.everything.design_patterns.headfirst.observer.java_native.subject;

import java.util.Observable;

/**
 * User: Makar Kalancha
 * Date: 29/07/14
 * Time: 2:32 PM
 */
public class WeatherData extends Observable {
    private float _temperature;
    private float _humidity;
    private float _pressure;

    public WeatherData(){}

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this._temperature = temperature;
        this._humidity = humidity;
        this._pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return _temperature;
    }

    public float getHumidity() {
        return _humidity;
    }

    public float getPressure() {
        return _pressure;
    }
}
