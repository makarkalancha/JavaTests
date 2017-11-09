package com.everything.unit_measurement;


import com.everything.unit_measurement.units.LengthUnit;

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
//        UnitValueConverter toKilometers = NonSI.MILE.getConverterTo(SI.KILOMETER);
//        double km = toKilometers.calculateMultiplier(Measure.valueOf(100, NonSI.MILE).doubleValue(NonSI.MILE));
//        System.out.println(km);

//        ServiceProvider serviceProvider = ServiceProvider.current();
//        QuantityFactory<Time> timeQuantityFactory = serviceProvider.getQuantityFactory(Time.class);
//        QuantityFactory<Length> lengthQuantityFactory = serviceProvider.getQuantityFactory(Length.class);
//        Quantity<Time> time = timeQuantityFactory.create(12, MILLI(SECOND));
//        Quantity<Length> length = lengthQuantityFactory.create(34.5, MILE);

        System.out.println("hours->seconds: " + TimeUnit.HOURS.toSeconds(1));
        System.out.println("meter->foot: " + LengthUnit.METER.toFoot(new BigDecimal("112")));
        System.out.println("meter->inch: " + LengthUnit.METER.toInch(new BigDecimal("112")));
        System.out.println("meter->meter: " + LengthUnit.METER.toMeter(new BigDecimal("112")));

        Unit each = Unit.PIECE;
        Unit liter = Unit.LITER;
        Unit kg = Unit.KG;
        Unit lb = Unit.LB;

        Class enumFromEach = UnitConverterConstructor.getEnumByKey(each.getUnitKey());
        System.out.println(enumFromEach);

        Class enumFromLiter = UnitConverterConstructor.getEnumByKey(liter.getUnitKey());
        System.out.println(enumFromLiter);

        Class enumFromKg = UnitConverterConstructor.getEnumByKey(kg.getUnitKey());
        System.out.println(enumFromKg);

        Class enumFromLb = UnitConverterConstructor.getEnumByKey(lb.getUnitKey());
        System.out.println(enumFromLb);

        System.out.println(UnitConverterConstructor.convertWeight(Unit.KG.getUnitKey(), new BigDecimal("10"), Unit.LB.getUnitKey()));
        System.out.println(UnitConverterConstructor.convertWeight(Unit.KG.getUnitKey(), new BigDecimal("10"), Unit.F_OZ.getUnitKey()));
    }
}
