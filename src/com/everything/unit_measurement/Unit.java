package com.everything.unit_measurement;

import com.everything.unit_measurement.units.VolumeUnit;
import com.everything.unit_measurement.units.WeightUnit;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 29/10/2017
 * Time: 16:22
 */
public enum Unit {
    F_OZ(VolumeUnit.FLUID_OUNCE_US.name(), "unit.f_oz", false, true, false, false){
        @Override
        public Set<Unit> getAlikeUnits() {
            return volumeUnits;
        }
    },
    GR(WeightUnit.GRAM.name(), "unit.gr", true, false, false, false){
        @Override
        public Set<Unit> getAlikeUnits() {
            return weightUnits;
        }
    },
    KG(WeightUnit.KILOGRAM.name(), "unit.kg", true, false, false, false){
        @Override
        public Set<Unit> getAlikeUnits() {
            return weightUnits;
        }
    },
    LB(WeightUnit.POUND.name(), "unit.lb", true, false, false, false){
        @Override
        public Set<Unit> getAlikeUnits() {
            return weightUnits;
        }
    },
    LITER(VolumeUnit.LITER.name(), "unit.liter", false, true, false, false){
        @Override
        public Set<Unit> getAlikeUnits() {
            return volumeUnits;
        }
    },
    OZ(WeightUnit.OUNCE.name(), "unit.oz", true, false, false, false){
        @Override
        public Set<Unit> getAlikeUnits() {
            return weightUnits;
        }
    },
    PIECE(null, "unit.piece", false, false, false, true){
        @Override
        public Set<Unit> getAlikeUnits() {
            return pieceUnits;
        }
    };

    private final String unitKey;
    private final String dictionaryKey;
    private final boolean isWeightUnit;
    private final boolean isVolumeUnit;
    private final boolean isLengthUnit;
    private final boolean isPieceUnit;
    private final Set<Unit> alikeUnits = new HashSet<>();

    private static final Set<Unit> weightUnits = new HashSet<>();
    private static final Set<Unit> volumeUnits = new HashSet<>();
    private static final Set<Unit> lengthUnits = new HashSet<>();
    private static final Set<Unit> pieceUnits = new HashSet<>();
    static {
        for(Unit unit : EnumSet.allOf(Unit.class)){
            if(unit.isWeightUnit){
                weightUnits.add(unit);
            }else if(unit.isVolumeUnit){
                volumeUnits.add(unit);
            }else if(unit.isLengthUnit){
                lengthUnits.add(unit);
            }else if(unit.isPieceUnit){
                pieceUnits.add(unit);
            }
        }
    }

    Unit(String unitKey, String dictionaryKey, boolean isWeightUnit, boolean isVolumeUnit, boolean isLengthUnit,
         boolean isPieceUnit
    ) {

        this.unitKey = unitKey;
        this.dictionaryKey = dictionaryKey;
        this.isWeightUnit = isWeightUnit;
        this.isVolumeUnit = isVolumeUnit;
        this.isLengthUnit = isLengthUnit;
        this.isPieceUnit = isPieceUnit;
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

    public boolean isPieceUnit() {
        return isPieceUnit;
    }

    public Set<Unit> getAlikeUnits() {
//        if(alikeUnits.isEmpty()){
//            if(this.isWeightUnit){
//                alikeUnits.addAll(weightUnits);
//            }else if(this.isVolumeUnit){
//                alikeUnits.addAll(volumeUnits);
//            }else if(this.isLengthUnit){
//                alikeUnits.addAll(lengthUnits);
//            }else if(this.isPieceUnit){
//                alikeUnits.addAll(pieceUnits);
//            }
//        }
//        return alikeUnits;
        throw new AbstractMethodError();
    }

    public static Set<Unit> getWeightUnits() {
        return weightUnits;
    }

    public static Set<Unit> getVolumeUnits() {
        return volumeUnits;
    }

    public static Set<Unit> getLengthUnits() {
        return lengthUnits;
    }

    public static Set<Unit> getPieceUnits() {
        return pieceUnits;
    }
}