package com.everything.unit_measurement.converters;

import com.everything.unit_measurement.Unit;

import java.math.BigDecimal;

/**
 * Created by mcalancea
 * Date: 09 Nov 2017
 * Time: 12:42
 */
public class UnitConverterMultiplier implements ConverterMultiplier {
    private ConverterMultiplier converterMultiplier;

    public UnitConverterMultiplier() {
    }

    public ConverterMultiplier getConverterMultiplier() {
        return converterMultiplier;
    }

    public void setConverterMultiplier(ConverterMultiplier converterMultiplier) {
        this.converterMultiplier = converterMultiplier;
    }

    @Override
    public BigDecimal getConverterMultiplier(Unit destination, Unit source, BigDecimal amount) {
        return converterMultiplier.getConverterMultiplier(destination, source, amount);
    }
}