package com.everything.unit_measurement.converters;

import java.math.BigDecimal;

/**
 * User: Makar Kalancha
 * Date: 28/10/2017
 * Time: 17:51
 */
public enum Volume {
    BARREL{
        @Override
        public BigDecimal toBarrel(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toCubicCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("159000"));
        }

        @Override
        public BigDecimal toCubicFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("5.6150320087"));
        }

        @Override
        public BigDecimal toCubicInch(BigDecimal value) {
            return value.multiply(new BigDecimal("9702.7753110624"));
        }

        @Override
        public BigDecimal toCubicMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.159"));
        }

        @Override
        public BigDecimal toCubicMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("159000000"));
        }

        @Override
        public BigDecimal toCubicYard(BigDecimal value) {
            return value.multiply(new BigDecimal("0.2079641485"));
        }

        @Override
        public BigDecimal toDeciliter(BigDecimal value) {
            return value.multiply(new BigDecimal("1590"));
        }

        @Override
        public BigDecimal toFluidOunceUS(BigDecimal value) {
            return value.multiply(new BigDecimal("5376,4349840229"));
        }

        @Override
        public BigDecimal toGallonUS(BigDecimal value) {
            return value.multiply(new BigDecimal("42,0033983127"));
        }

        @Override
        public BigDecimal toHectoliter(BigDecimal value) {
            return value.multiply(new BigDecimal("1,59"));
        }

        @Override
        public BigDecimal toLiter(BigDecimal value) {
            return value.multiply(new BigDecimal("159"));
        }

        @Override
        public BigDecimal toMilliliter(BigDecimal value) {
            return value.multiply(new BigDecimal("159000"));
        }

        @Override
        public BigDecimal toPintUS(BigDecimal value) {
            return value.multiply(new BigDecimal("336,0271865014"));
        }

        @Override
        public BigDecimal toQuartUS(BigDecimal value) {
            return value.multiply(new BigDecimal("168,0135932507"));
        }
    },
    CUBIC_CENTIMETER{
        @Override
        public BigDecimal toBarrel(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000062893"));
        }

        @Override
        public BigDecimal toCubicCentimeter(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toCubicFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("0,00003531466672148859"));
        }

        @Override
        public BigDecimal toCubicInch(BigDecimal value) {
            return value.multiply(new BigDecimal("0,0610237440947323"));
        }

        @Override
        public BigDecimal toCubicMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,000001"));
        }

        @Override
        public BigDecimal toCubicMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("1000"));
        }

        @Override
        public BigDecimal toCubicYard(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000001307950619314392"));
        }

        @Override
        public BigDecimal toDeciliter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.01"));
        }

        @Override
        public BigDecimal toFluidOunceUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0,033814022701843"));
        }

        @Override
        public BigDecimal toGallonUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0,0002641720523581484"));
        }

        @Override
        public BigDecimal toHectoliter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,00001"));
        }

        @Override
        public BigDecimal toLiter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,001"));
        }

        @Override
        public BigDecimal toMilliliter(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toPintUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0,0021133764188652"));
        }

        @Override
        public BigDecimal toQuartUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0,0010566882094326"));
        }
    },
    CUBIC_FOOT{
        @Override
        public BigDecimal toBarrel(BigDecimal value) {
            return value.multiply(new BigDecimal("0,1780933748"));
        }

        @Override
        public BigDecimal toCubicCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("28316,846592"));
        }

        @Override
        public BigDecimal toCubicFoot(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toCubicInch(BigDecimal value) {
            return value.multiply(new BigDecimal("1728"));
        }

        @Override
        public BigDecimal toCubicMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,028316846592"));
        }

        @Override
        public BigDecimal toCubicMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("28316846,592"));
        }

        @Override
        public BigDecimal toCubicYard(BigDecimal value) {
            return value.multiply(new BigDecimal("0,037037037037037"));
        }

        @Override
        public BigDecimal toDeciliter(BigDecimal value) {
            return value.multiply(new BigDecimal("283,16846592"));
        }

        @Override
        public BigDecimal toFluidOunceUS(BigDecimal value) {
            return value.multiply(new BigDecimal("957,5064935064935"));
        }

        @Override
        public BigDecimal toGallonUS(BigDecimal value) {
            return value.multiply(new BigDecimal("7,480519480519481"));
        }

        @Override
        public BigDecimal toHectoliter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,28316846592"));
        }

        @Override
        public BigDecimal toLiter(BigDecimal value) {
            return value.multiply(new BigDecimal("28,316846592"));
        }

        @Override
        public BigDecimal toMilliliter(BigDecimal value) {
            return value.multiply(new BigDecimal("28316.846592"));
        }

        @Override
        public BigDecimal toPintUS(BigDecimal value) {
            return value.multiply(new BigDecimal("59,84415584415584"));
        }

        @Override
        public BigDecimal toQuartUS(BigDecimal value) {
            return value.multiply(new BigDecimal("29,92207792207792"));
        }
    },
    CUBIC_INCH,
    CUBIC_METER,
    CUBIC_MILLIMETER,
    CUBIC_YARD,
    DECILITER,
    FLUID_OUNCE_US,
    GALLON_US,
    HECTOLITER,
    LITER,
    MILLILITER,
    PINT_US,
    QUART_US;

    public BigDecimal toBarrel(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toCubicCentimeter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toCubicFoot(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toCubicInch(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toCubicMeter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toCubicMillimeter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toCubicYard(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toDeciliter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toFluidOunceUS(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toGallonUS(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toHectoliter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toLiter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toMilliliter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toPintUS(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toQuartUS(BigDecimal value) {
        throw new AbstractMethodError();
    }
}