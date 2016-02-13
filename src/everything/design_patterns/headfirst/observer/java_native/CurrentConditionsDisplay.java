package everything.design_patterns.headfirst.observer.java_native;


import everything.design_patterns.headfirst.observer.java_native.subject.WeatherData;
import everything.design_patterns.headfirst.observer.not_java_native.display.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 1:54 PM
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    private Observable _observable;
    private float _temperature;
    private float _humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this._observable = observable;
        this._observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: "+_temperature+
        " F degrees and "+_humidity+"% humidity.");
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData) obs;
            this._temperature = weatherData.getTemperature();
            this._humidity = weatherData.getHumidity();
            display();
        }
    }
}
