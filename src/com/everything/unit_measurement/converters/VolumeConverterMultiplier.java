package com.everything.unit_measurement.converters;

import com.everything.unit_measurement.Unit;
import com.everything.unit_measurement.units.VolumeUnit;

import java.math.BigDecimal;

/**
 * Created by mcalancea
 * Date: 09 Nov 2017
 * Time: 12:40
 */
public class VolumeConverterMultiplier implements ConverterMultiplier {
    @Override
    public BigDecimal getConverterMultiplier(Unit destination, Unit source, BigDecimal amount) {
        BigDecimal result = null;
        if(destination.isVolumeUnit() && source.isVolumeUnit()){
            VolumeUnit srcLengthUnit = VolumeUnit.valueOf(source.getUnitKey());
            VolumeUnit dstLengthUnit = VolumeUnit.valueOf(destination.getUnitKey());
            result = dstLengthUnit.convert(amount, srcLengthUnit);
        }
        return result;
    }
}