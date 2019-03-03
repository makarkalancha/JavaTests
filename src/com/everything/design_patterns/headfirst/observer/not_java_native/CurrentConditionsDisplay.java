package com.everything.design_patterns.headfirst.observer.not_java_native;

import com.everything.design_patterns.headfirst.observer.not_java_native.display.DisplayElement;
import com.everything.design_patterns.headfirst.observer.not_java_native.observer.Observer;
import com.everything.design_patterns.headfirst.observer.not_java_native.subject.Subject;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 1:54 PM
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    private float _temperature;
    private float _humidity;
    private Subject _weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this._weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: "+_temperature+
        " F degrees and "+_humidity+"% humidity.");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this._temperature = temperature;
        this._humidity = humidity;
        display();
    }
}
