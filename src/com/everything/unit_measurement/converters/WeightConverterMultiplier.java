package com.everything.unit_measurement.converters;

import com.everything.unit_measurement.Unit;
import com.everything.unit_measurement.units.WeightUnit;

import java.math.BigDecimal;

/**
 * Created by mcalancea
 * Date: 09 Nov 2017
 * Time: 12:33
 */
public class WeightConverterMultiplier implements ConverterMultiplier {
    @Override
    public BigDecimal calculateMultiplier(Unit destination, Unit source, BigDecimal amount) {
        BigDecimal result = null;
        if(destination.isWeightUnit() && source.isWeightUnit()){
            WeightUnit srcWeightUnit = WeightUnit.valueOf(source.getUnitKey());
            WeightUnit dstWeightUnit = WeightUnit.valueOf(destination.getUnitKey());
            result = dstWeightUnit.convert(amount, srcWeightUnit);
        }
        return result;
    }
}