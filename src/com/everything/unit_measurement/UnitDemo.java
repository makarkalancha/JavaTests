package com.everything.unit_measurement;


import com.everything.unit_measurement.converters.Length;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * User: Makar Kalancha
 * Date: 28/10/2017
 * Time: 14:58
 *
 <!-- https://mvnrepository.com/artifact/javax.measure/unit-api -->
 <dependency>
 <groupId>javax.measure</groupId>
 <artifactId>unit-api</artifactId>
 <version>1.0</version>
 </dependency>

 <!-- https://mvnrepository.com/artifact/javax.measure/jsr-275 -->
 <dependency>
 <groupId>javax.measure</groupId>
 <artifactId>jsr-275</artifactId>
 <version>1.0.0</version>
 </dependency>

 <!-- https://mvnrepository.com/artifact/org.jscience/jscience -->
 <dependency>
 <groupId>org.jscience</groupId>
 <artifactId>jscience</artifactId>
 <version>4.3.1</version>
 </dependency>
 */
public class UnitDemo {
    public static void main(String[] args) {
//        UnitConverter toKilometers = NonSI.MILE.getConverterTo(SI.KILOMETER);
//        double km = toKilometers.convert(Measure.valueOf(100, NonSI.MILE).doubleValue(NonSI.MILE));
//        System.out.println(km);

//        ServiceProvider serviceProvider = ServiceProvider.current();
//        QuantityFactory<Time> timeQuantityFactory = serviceProvider.getQuantityFactory(Time.class);
//        QuantityFactory<Length> lengthQuantityFactory = serviceProvider.getQuantityFactory(Length.class);
//        Quantity<Time> time = timeQuantityFactory.create(12, MILLI(SECOND));
//        Quantity<Length> length = lengthQuantityFactory.create(34.5, MILE);

        System.out.println("hours->seconds: " + TimeUnit.HOURS.toSeconds(1));
        System.out.println("meter->foot: " + Length.METER.toFoot(new BigDecimal("112")));
        System.out.println("meter->inch: " + Length.METER.toInch(new BigDecimal("112")));
        System.out.println("meter->meter: " + Length.METER.toMeter(new BigDecimal("112")));
    }
}
