package com.everything.unit_measurement.converters;

import com.everything.unit_measurement.Unit;

import java.math.BigDecimal;

/**
 * Created by mcalancea
 * Date: 09 Nov 2017
 * Time: 12:33
 */
public interface Converter {
    BigDecimal getConverterMultiplier(Unit destination, Unit source, BigDecimal amount);
}
