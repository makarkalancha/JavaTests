package com.everything.unit_measurement;

import com.everything.unit_measurement.converters.Converter;
import com.everything.unit_measurement.converters.LengthConverter;
import com.everything.unit_measurement.converters.PieceConverter;
import com.everything.unit_measurement.converters.UnitConverter;
import com.everything.unit_measurement.converters.VolumeConverter;
import com.everything.unit_measurement.converters.WeightConverter;
import com.everything.unit_measurement.pojo.Commodity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mcalancea
 * Date: 09 Nov 2017
 * Time: 12:45
 */
public class UnitConverterDemo {
    public static void main(String[] args) {
        //state design pattern
        UnitConverter unitConverter = new UnitConverter();

        Converter weight = new WeightConverter();
        Converter length = new LengthConverter();
        Converter volume = new VolumeConverter();
        Converter piece = new PieceConverter();
        Unit dst;

//        unitConverter.setConverter(weight);
//        System.out.println(unitConverter.getConverterMultiplier(Unit.GR, Unit.OZ, new BigDecimal("30")));
//
//        unitConverter.setConverter(volume);
//        System.out.println(unitConverter.getConverterMultiplier(Unit.LITER, Unit.F_OZ, new BigDecimal("13")));

        System.out.println("===================================================================================");
        Commodity commodity1 = new Commodity("name1", new BigDecimal("1.29"), Unit.KG, BigDecimal.ONE);
        Commodity commodity2 = new Commodity("name2", new BigDecimal("0.67"), Unit.LB, BigDecimal.ONE);
        List<Commodity> commodities1And2 = Arrays.asList(commodity1, commodity2);
        dst = Unit.KG;

        unitConverter.setConverter(weight);
        for(Commodity commodity : commodities1And2) {
            getPricePerOneUnit(unitConverter, dst, commodity);
        }
        System.out.println("===================================================================================");
        Commodity commodity3 = new Commodity("name3", new BigDecimal("15.99"), Unit.PIECE, new BigDecimal("12750"));
        Commodity commodity4 = new Commodity("name4", new BigDecimal("14.99"), Unit.PIECE, new BigDecimal("9360"));
        List<Commodity> commodities3And4 = Arrays.asList(commodity3, commodity4);
        dst = Unit.PIECE;

        unitConverter.setConverter(piece);
        for(Commodity commodity : commodities3And4) {
            getPricePerOneUnit(unitConverter, dst, commodity);
        }
    }

    private static void getPricePerOneUnit(UnitConverter unitConverter, Unit dst, Commodity commodity){
        BigDecimal dstUnitMultiplier = unitConverter.getConverterMultiplier(commodity.getUnit(), dst, commodity.getUnit_value());
        System.out.println("dstUnitMultiplier: " + dstUnitMultiplier);
        BigDecimal newPricePerOneUnit = commodity.getPrice().multiply(dstUnitMultiplier);
        System.out.println("newPricePerOneUnit: " + newPricePerOneUnit);
    }
}
