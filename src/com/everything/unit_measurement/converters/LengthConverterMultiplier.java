package com.everything.unit_measurement.converters;

import com.everything.unit_measurement.Unit;
import com.everything.unit_measurement.units.LengthUnit;

import java.math.BigDecimal;

/**
 * Created by mcalancea
 * Date: 09 Nov 2017
 * Time: 12:35
 */
public class LengthConverterMultiplier implements ConverterMultiplier {
    @Override
    public BigDecimal calculateMultiplier(Unit destination, Unit source, BigDecimal amount) {
        BigDecimal result = null;
        if(destination.isLengthUnit() && source.isLengthUnit()){
            LengthUnit srcLengthUnit = LengthUnit.valueOf(source.getUnitKey());
            LengthUnit dstLengthUnit = LengthUnit.valueOf(destination.getUnitKey());
            result = dstLengthUnit.convert(amount, srcLengthUnit);
        }
        return result;
    }
}