package com.everything.unit_measurement;

import com.everything.unit_measurement.units.LengthUnit;
import com.everything.unit_measurement.units.VolumeUnit;
import com.everything.unit_measurement.units.WeightUnit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Makar Kalancha
 * Date: 29/10/2017
 * Time: 16:22
 */
public class UnitConverterConstructor {
    private static Map<String, Class<?>> valueToConverter = new HashMap<>();
    static {
        for(LengthUnit lengthUnit : LengthUnit.values()) {
            valueToConverter.put(lengthUnit.toString(), LengthUnit.class);
        }
        for(VolumeUnit volumeUnit : VolumeUnit.values()) {
            valueToConverter.put(volumeUnit.toString(), VolumeUnit.class);
        }
        for(WeightUnit weightUnit : WeightUnit.values()) {
            valueToConverter.put(weightUnit.toString(), WeightUnit.class);
        }
        System.out.println("static initialization");
    }

    public static BigDecimal convertWeight(String source, BigDecimal value, String destination){
        WeightUnit sourceW = WeightUnit.valueOf(source);
        WeightUnit destinationW = WeightUnit.valueOf(destination);
        return sourceW.convert(value, destinationW);
    }

    public static BigDecimal convertWeigh1t(Unit source, BigDecimal value, Unit destination){
        if(source.isWeightUnit() && destination.isWeightUnit()) {
            WeightUnit sourceW = WeightUnit.valueOf(source.getDictionaryKey());
            WeightUnit destinationW = WeightUnit.valueOf(destination.getDictionaryKey());
            return sourceW.convert(value, destinationW);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Class<?> getEnumByKey(String key){
        return valueToConverter.get(key);
    }
}