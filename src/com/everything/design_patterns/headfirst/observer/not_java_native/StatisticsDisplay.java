package com.everything.design_patterns.headfirst.observer.not_java_native;

import com.everything.design_patterns.headfirst.observer.not_java_native.display.DisplayElement;
import com.everything.design_patterns.headfirst.observer.not_java_native.observer.Observer;
import com.everything.design_patterns.headfirst.observer.not_java_native.subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 1:54 PM
 */
public class StatisticsDisplay implements Observer,DisplayElement {
    private List<Float> _temperatures = new ArrayList<>();
    private float _avg;
    private float _min;
    private float _max;
    private Subject _weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this._weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Avg/Min/Max temperature = : "+this._avg+
        " / "+this._min+" / "+this._max);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this._temperatures.add(temperature);
        calculateStats();
        display();
    }

    private void calculateStats(){
        double sum = 0;
        for(int i = 0 ; i < this._temperatures.size() ; i++){
            sum+=this._temperatures.get(i);
            if(i == 0 || this._temperatures.get(i) < this._min){
                this._min = this._temperatures.get(i);
            }

            if(i == 0 || this._temperatures.get(i) > this._max){
                this._max = this._temperatures.get(i);
            }
        }

        this._avg = (float) (sum / this._temperatures.size());
    }
}
