package com.everything.unit_measurement;

import com.everything.unit_measurement.converters.ConverterMultiplier;
import com.everything.unit_measurement.converters.LengthConverterMultiplier;
import com.everything.unit_measurement.converters.PieceConverterMultiplier;
import com.everything.unit_measurement.converters.UnitConverterMultiplier;
import com.everything.unit_measurement.converters.VolumeConverterMultiplier;
import com.everything.unit_measurement.converters.WeightConverterMultiplier;
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
        UnitConverterMultiplier unitValueConverter = new UnitConverterMultiplier();

        ConverterMultiplier weight = new WeightConverterMultiplier();
        ConverterMultiplier length = new LengthConverterMultiplier();
        ConverterMultiplier volume = new VolumeConverterMultiplier();
        ConverterMultiplier piece = new PieceConverterMultiplier();
        Unit dst;

//        unitValueConverter.setConverter(weight);
//        System.out.println(unitValueConverter.calculateMultiplier(Unit.GR, Unit.OZ, new BigDecimal("30")));
//
//        unitValueConverter.setConverter(volume);
//        System.out.println(unitValueConverter.calculateMultiplier(Unit.LITER, Unit.F_OZ, new BigDecimal("13")));

        System.out.println("===================================================================================");
        Commodity commodity1 = new Commodity("name1", new BigDecimal("1.29"), Unit.KG, BigDecimal.ONE);
        Commodity commodity2 = new Commodity("name2", new BigDecimal("0.67"), Unit.LB, BigDecimal.ONE);
        List<Commodity> commodities1And2 = Arrays.asList(commodity1, commodity2);
        dst = Unit.KG;

        unitValueConverter.setConverterMultiplier(weight);
        for(Commodity commodity : commodities1And2) {
            getPricePerOneUnit(unitValueConverter, dst, commodity);
        }
        System.out.println("===================================================================================");
        Commodity commodity3 = new Commodity("name3", new BigDecimal("15.99"), Unit.PIECE, new BigDecimal("12750"));
        Commodity commodity4 = new Commodity("name4", new BigDecimal("14.99"), Unit.PIECE, new BigDecimal("9360"));
        List<Commodity> commodities3And4 = Arrays.asList(commodity3, commodity4);
        dst = Unit.PIECE;

        unitValueConverter.setConverterMultiplier(piece);
        for(Commodity commodity : commodities3And4) {
            getPricePerOneUnit(unitValueConverter, dst, commodity);
        }
    }

    private static void getPricePerOneUnit(UnitConverterMultiplier unitValueConverter, Unit dst, Commodity commodity){
        BigDecimal dstUnitMultiplier = unitValueConverter.calculateMultiplier(commodity.getUnit(), dst, commodity.getUnitValue());
        System.out.println("dstUnitMultiplier: " + dstUnitMultiplier);
        BigDecimal newPricePerOneUnit = commodity.getPrice().multiply(dstUnitMultiplier);
        System.out.println("newPricePerOneUnit: " + newPricePerOneUnit);
    }
}
