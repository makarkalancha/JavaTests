package com.everything.unit_measurement.converters;

import com.everything.unit_measurement.Unit;

import java.math.BigDecimal;

/**
 * Created by mcalancea
 * Date: 09 Nov 2017
 * Time: 12:33
 */
public class PieceConverterMultiplier implements ConverterMultiplier {
    @Override
    public BigDecimal calculateMultiplier(Unit destination, Unit source, BigDecimal amount) {
        BigDecimal result = null;
        if(destination.isPieceUnit() && source.isPieceUnit() && destination.equals(source)){
            result = BigDecimal.ONE.divide(amount, 9, BigDecimal.ROUND_HALF_UP);
        }
        return result;
    }
}