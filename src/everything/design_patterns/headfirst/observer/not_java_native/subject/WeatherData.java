package everything.design_patterns.headfirst.observer.not_java_native.subject;

import everything.design_patterns.headfirst.observer.not_java_native.observer.Observer;

import java.util.ArrayList;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 1:18 PM
 */
public class WeatherData implements Subject {
    private ArrayList<Observer> _observers;
    private float _temperature;
    private float _humidity;
    private float _pressure;

    public WeatherData() {
        _observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        _observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for(int i = 0 ; i < _observers.size();i++) {
            Observer observer = _observers.get(i);
            observer.update(_temperature, _humidity, _pressure);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = _observers.indexOf(observer);
        if(i >= 0) {
            _observers.remove(i);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this._temperature = temperature;
        this._humidity = humidity;
        this._pressure = pressure;
        measurementsChanged();
    }
}
