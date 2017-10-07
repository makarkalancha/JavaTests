package com.everything.design_patterns.headfirst.observer.not_java_native;

import com.everything.design_patterns.headfirst.observer.not_java_native.display.DisplayElement;
import com.everything.design_patterns.headfirst.observer.not_java_native.observer.Observer;
import com.everything.design_patterns.headfirst.observer.not_java_native.subject.Subject;

/**
 * User: Makar Kalancha
 * Date: 30/07/14
 * Time: 1:40 PM
 */
public class ForecastDisplay implements Observer,DisplayElement {
    private Subject _weatherData;
    private float _currentPressure = 29.92f;
    private float _lastPressure;
    public ForecastDisplay(Subject weatherData) {
        this._weatherData = weatherData;
        this._weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Forecast: last pressure="+this._lastPressure+"; current pressure="+this._currentPressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this._lastPressure = this._currentPressure;
        this._currentPressure = pressure;
        display();
    }
}
