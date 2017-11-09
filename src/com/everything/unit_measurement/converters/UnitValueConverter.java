package com.everything.unit_measurement.converters;

import com.everything.unit_measurement.Unit;

import java.math.BigDecimal;

/**
 * Created by mcalancea
 * Date: 09 Nov 2017
 * Time: 12:42
 */
public class UnitValueConverter implements Converter {
    private Converter converter;

    public UnitValueConverter() {
    }

    public Converter getConverter() {
        return converter;
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    @Override
    public BigDecimal getConverterMultiplier(Unit destination, Unit source, BigDecimal amount) {
        return converter.getConverterMultiplier(destination, source, amount);
    }
}
