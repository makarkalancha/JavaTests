package com.everything.design_patterns.headfirst.observer.not_java_native.subject;

import com.everything.design_patterns.headfirst.observer.not_java_native.observer.Observer;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 1:12 PM
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void notifyObservers();
    public void removeObserver(Observer observer);
}
