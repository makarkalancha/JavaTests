package com.everything.serialization;

/**
 * Created by Makar Kalancha
 * Date: 30 Aug 2017
 * Time: 16:05
 */
public class Address {
    private final String street;
    private final String city;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
