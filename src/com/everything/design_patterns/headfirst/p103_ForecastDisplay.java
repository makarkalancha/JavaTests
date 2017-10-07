package com.everything.design_patterns.headfirst;

import java.util.Observable;
import java.util.Observer;

/**
 * User: Makar Kalancha
 * Date: 16/07/14
 * Time: 3:06 PM
 */
public class p103_ForecastDisplay implements Observer/*, DisplayElement*/{
    private float currentPressure= 29.92f;
    private float lastPressure;
    public p103_ForecastDisplay(Observable observable){
        observable.addObserver(this);
        display();
    }

    public void update(Observable observable,Object arg) {
//        if(observable instanceof WeatherData){
//            WeatherData weatherData = (WeatherData) observable;
//        }
    }

    public void display(){

    }
}
