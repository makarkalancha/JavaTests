package com.everything.inheritance;

import javafx.concurrent.Service;

/**
 * Created by mcalancea
 * Date: 10 Nov 2017
 * Time: 18:35
 */
public class OverridenTest {
    test if 2 variables refer to same object, but they have different overriden methods
            A a1 = new A();
            A a2 = a1;

    a1.do(){
        return 1;
    }

    a2.do(){
        return 2;
    }
    ((Service<Void>) onWorker).setOnSucceeded(event -> {
}
