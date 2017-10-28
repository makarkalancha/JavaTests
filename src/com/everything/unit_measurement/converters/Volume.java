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
    CUBIC_INCH{
        @Override
        public BigDecimal toBarrel(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0001030633"));
        }

        @Override
        public BigDecimal toCubicCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("16,387064"));
        }

        @Override
        public BigDecimal toCubicFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0005787037037037037"));
        }

        @Override
        public BigDecimal toCubicInch(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toCubicMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,000016387064"));
        }

        @Override
        public BigDecimal toCubicMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("16387,064"));
        }

        @Override
        public BigDecimal toCubicYard(BigDecimal value) {
            return value.multiply(new BigDecimal("0,00002143347050754458"));
        }

        @Override
        public BigDecimal toDeciliter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,16387064"));
        }

        @Override
        public BigDecimal toFluidOunceUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0,5541125541125541"));
        }

        @Override
        public BigDecimal toGallonUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0,0043290043290043"));
        }

        @Override
        public BigDecimal toHectoliter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,00016387064"));
        }

        @Override
        public BigDecimal toLiter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,016387064"));
        }

        @Override
        public BigDecimal toMilliliter(BigDecimal value) {
            return value.multiply(new BigDecimal("16,387064"));
        }

        @Override
        public BigDecimal toPintUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0,0346320346320346"));
        }

        @Override
        public BigDecimal toQuartUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0,0173160173160173"));
        }
    },
    CUBIC_METER{
        @Override
        public BigDecimal toBarrel(BigDecimal value) {
            return value.multiply(new BigDecimal("6.2893081761"));
        }

        @Override
        public BigDecimal toCubicCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("1000000"));
        }

        @Override
        public BigDecimal toCubicFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("35,31466672148859"));
        }

        @Override
        public BigDecimal toCubicInch(BigDecimal value) {
            return value.multiply(new BigDecimal("61023,74409473228"));
        }

        @Override
        public BigDecimal toCubicMeter(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toCubicMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("1000000000"));
        }

        @Override
        public BigDecimal toCubicYard(BigDecimal value) {
            return value.multiply(new BigDecimal("1,307950619314392"));
        }

        @Override
        public BigDecimal toDeciliter(BigDecimal value) {
            return value.multiply(new BigDecimal("10000"));
        }

        @Override
        public BigDecimal toFluidOunceUS(BigDecimal value) {
            return value.multiply(new BigDecimal("33814,022701843"));
        }

        @Override
        public BigDecimal toGallonUS(BigDecimal value) {
            return value.multiply(new BigDecimal("264,1720523581484"));
        }

        @Override
        public BigDecimal toHectoliter(BigDecimal value) {
            return value.multiply(BigDecimal.TEN);
        }

        @Override
        public BigDecimal toLiter(BigDecimal value) {
            return value.multiply(new BigDecimal("1000"));
        }

        @Override
        public BigDecimal toMilliliter(BigDecimal value) {
            return value.multiply(new BigDecimal("1000000"));
        }

        @Override
        public BigDecimal toPintUS(BigDecimal value) {
            return value.multiply(new BigDecimal("2113,376418865187"));
        }

        @Override
        public BigDecimal toQuartUS(BigDecimal value) {
            return value.multiply(new BigDecimal("1056,688209432594"));
        }
    },
    CUBIC_MILLIMETER{
        @Override
        public BigDecimal toBarrel(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000000063"));
        }

        @Override
        public BigDecimal toCubicCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.001"));
        }

        @Override
        public BigDecimal toCubicFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000000353"));
        }

        @Override
        public BigDecimal toCubicInch(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000610237"));
        }

        @Override
        public BigDecimal toCubicMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000000001"));
        }

        @Override
        public BigDecimal toCubicMillimeter(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toCubicYard(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000000013"));
        }

        @Override
        public BigDecimal toDeciliter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.00001"));
        }

        @Override
        public BigDecimal toFluidOunceUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000338141"));
        }

        @Override
        public BigDecimal toGallonUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000002642"));
        }

        @Override
        public BigDecimal toHectoliter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.00000001"));
        }

        @Override
        public BigDecimal toLiter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000001"));
        }

        @Override
        public BigDecimal toMilliliter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.001"));
        }

        @Override
        public BigDecimal toPintUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000021134"));
        }

        @Override
        public BigDecimal toQuartUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000010567"));
        }
    },
    CUBIC_YARD{
        @Override
        public BigDecimal toBarrel(BigDecimal value) {
            return value.multiply(new BigDecimal("4,8085211194"));
        }

        @Override
        public BigDecimal toCubicCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("764554,857984"));
        }

        @Override
        public BigDecimal toCubicFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("27"));
        }

        @Override
        public BigDecimal toCubicInch(BigDecimal value) {
            return value.multiply(new BigDecimal("46656"));
        }

        @Override
        public BigDecimal toCubicMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,764554857984"));
        }

        @Override
        public BigDecimal toCubicMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000000764554857984"));
        }

        @Override
        public BigDecimal toCubicYard(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toDeciliter(BigDecimal value) {
            return value.multiply(new BigDecimal("7645,54857984"));
        }

        @Override
        public BigDecimal toFluidOunceUS(BigDecimal value) {
            return value.multiply(new BigDecimal("25852,67532467532"));
        }

        @Override
        public BigDecimal toGallonUS(BigDecimal value) {
            return value.multiply(new BigDecimal("201,974025974026"));
        }

        @Override
        public BigDecimal toHectoliter(BigDecimal value) {
            return value.multiply(new BigDecimal("7,64554857984"));
        }

        @Override
        public BigDecimal toLiter(BigDecimal value) {
            return value.multiply(new BigDecimal("764,554857984"));
        }

        @Override
        public BigDecimal toMilliliter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,0000764554857984"));
        }

        @Override
        public BigDecimal toPintUS(BigDecimal value) {
            return value.multiply(new BigDecimal("1615,792207792208"));
        }

        @Override
        public BigDecimal toQuartUS(BigDecimal value) {
            return value.multiply(new BigDecimal("807,8961038961039"));
        }
    },
    DECILITER{
        @Override
        public BigDecimal toBarrel(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0006289308"));
        }

        @Override
        public BigDecimal toCubicCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("100"));
        }

        @Override
        public BigDecimal toCubicFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0035314667"));
        }

        @Override
        public BigDecimal toCubicInch(BigDecimal value) {
            return value.multiply(new BigDecimal("6,1023744095"));
        }

        @Override
        public BigDecimal toCubicMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0,0001"));
        }

        @Override
        public BigDecimal toCubicMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("100000"));
        }

        @Override
        public BigDecimal toCubicYard(BigDecimal value) {
            return value.multiply(new BigDecimal("100000"));
        }

        @Override
        public BigDecimal toDeciliter(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toFluidOunceUS(BigDecimal value) {
            return value.multiply(new BigDecimal("3.3814056503"));
        }

        @Override
        public BigDecimal toGallonUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0264172316"));
        }

        @Override
        public BigDecimal toHectoliter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.001"));
        }

        @Override
        public BigDecimal toLiter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.1"));
        }

        @Override
        public BigDecimal toMilliliter(BigDecimal value) {
            return value.multiply(new BigDecimal("100"));
        }

        @Override
        public BigDecimal toPintUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0,2113378531"));
        }

        @Override
        public BigDecimal toQuartUS(BigDecimal value) {
            return value.multiply(new BigDecimal("0,1056689266"));
        }
    },
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