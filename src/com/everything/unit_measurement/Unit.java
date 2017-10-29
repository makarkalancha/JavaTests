package com.everything.unit_measurement;

import com.everything.unit_measurement.converters.VolumeUnit;
import com.everything.unit_measurement.converters.WeightUnit;

/**
 * User: Makar Kalancha
 * Date: 29/10/2017
 * Time: 16:22
 */
public enum Unit {
    EACH(null, "unit.each", false, false, false),
    F_OZ(VolumeUnit.FLUID_OUNCE_US.name(), "unit.f_oz", false, true, false),
    KG(WeightUnit.KILOGRAM.name(), "unit.kg", true, false, false),
    LB(WeightUnit.POUND.name(), "unit.lb", true, false, false),
    LITER(VolumeUnit.LITER.name(), "unit.liter", false, true, false),
    GR(WeightUnit.GRAM.name(), "unit.gr", true, false, false),
    OZ(WeightUnit.OUNCE.name(), "unit.oz", true, false, false);

    private final String unitKey;
    private final String dictionaryKey;
    private final boolean isWeightUnit;
    private final boolean isVolumeUnit;
    private final boolean isLengthUnit;

    Unit(String unitKey, String dictionaryKey, boolean isWeightUnit, boolean isVolumeUnit, boolean isLengthUnit) {
        this.unitKey = unitKey;
        this.dictionaryKey = dictionaryKey;
        this.isWeightUnit = isWeightUnit;
        this.isVolumeUnit = isVolumeUnit;
        this.isLengthUnit = isLengthUnit;
    }

    public String getUnitKey() {
        return unitKey;
    }

    public String getDictionaryKey() {
        return dictionaryKey;
    }

    public boolean isWeightUnit() {
        return isWeightUnit;
    }

    public boolean isVolumeUnit() {
        return isVolumeUnit;
    }

    public boolean isLengthUnit() {
        return isLengthUnit;
    }
}