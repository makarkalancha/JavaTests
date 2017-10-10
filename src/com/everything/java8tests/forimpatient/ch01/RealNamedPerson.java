package com.everything.java8tests.forimpatient.ch01;

/**
 * User: Makar Kalancha
 * Date: 30/01/2015
 * Time: 17:06
 */
public class RealNamedPerson implements Person, Named {
    private long id;
    private String name;

    public RealNamedPerson(long id) {
        this.id = id;
    }

    public RealNamedPerson(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        if (name == null) {
            return Person.super.getName();
        } else if (name.length() == 3) {
            return Named.super.getName();
        }
        return name;
    }
}
