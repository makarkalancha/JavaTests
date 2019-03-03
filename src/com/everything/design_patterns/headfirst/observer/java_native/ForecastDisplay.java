package com.everything.design_patterns.headfirst.observer.java_native;


import com.everything.design_patterns.headfirst.observer.java_native.subject.WeatherData;
import com.everything.design_patterns.headfirst.observer.not_java_native.display.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 1:54 PM
 */
public class ForecastDisplay implements Observer,DisplayElement {
    private Observable _observable;
    private float _currentPressure = 29.92f;
    private float _lastPressure;

    public ForecastDisplay(Observable observable) {
        this._observable = observable;
        this._observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Forecast: last pressure="+this._lastPressure+"; current pressure="+this._currentPressure);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData) obs;
            this._lastPressure = this._currentPressure;
            this._currentPressure = weatherData.getPressure();
            display();
        }
    }
}
