package com.everything.unit_measurement.units;

import java.math.BigDecimal;

/**
 * User: Makar Kalancha
 * Date: 28/10/2017
 * Time: 16:22
 */
public enum LengthUnit {
    CENTIMETER {
        @Override
        public BigDecimal convert(BigDecimal value, LengthUnit lengthUnit) {
            return lengthUnit.toCentimeter(value);
        }

        @Override
        public BigDecimal toCentimeter(BigDecimal value) {
            return value;
        }

        @Override
        public BigDecimal toDecimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.1"));
        }

        @Override
        public BigDecimal toFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0328083989501312"));
        }

        @Override
        public BigDecimal toInch(BigDecimal value) {
            return value.multiply(new BigDecimal("0.3937007874015748"));
        }

        @Override
        public BigDecimal toKilometer(BigDecimal value) {
            return value.multiply(new BigDecimal("0.00001"));
        }

        @Override
        public BigDecimal toMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.01"));
        }

        @Override
        public BigDecimal toMile(BigDecimal value) {
            return value.multiply(new BigDecimal("0.00000621371192237334"));
        }

        @Override
        public BigDecimal toMillimeter(BigDecimal value) {
            return value.multiply(BigDecimal.TEN);
        }

        @Override
        public BigDecimal toYard(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0109361329833771"));
        }
    },
    DECIMETER {
        @Override
        public BigDecimal convert(BigDecimal value, LengthUnit lengthUnit) {
            return lengthUnit.toDecimeter(value);
        }

        @Override
        public BigDecimal toCentimeter(BigDecimal value) {
            return value.multiply(BigDecimal.TEN);
        }

        @Override
        public BigDecimal toDecimeter(BigDecimal value) {
            return value;
        }

        @Override
        public BigDecimal toFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("0.328083989501312"));
        }

        @Override
        public BigDecimal toInch(BigDecimal value) {
            return value.multiply(new BigDecimal("3.937007874015748"));
        }

        @Override
        public BigDecimal toKilometer(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0001"));
        }

        @Override
        public BigDecimal toMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.1"));
        }

        @Override
        public BigDecimal toMile(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000621371192237334"));
        }

        @Override
        public BigDecimal toMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("100"));
        }

        @Override
        public BigDecimal toYard(BigDecimal value) {
            return value.multiply(new BigDecimal("0.109361329833771"));
        }
    },
    FOOT {
        @Override
        public BigDecimal convert(BigDecimal value, LengthUnit lengthUnit) {
            return lengthUnit.toFoot(value);
        }

        @Override
        public BigDecimal toCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("30.48"));
        }

        @Override
        public BigDecimal toDecimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("3.048"));
        }

        @Override
        public BigDecimal toFoot(BigDecimal value) {
            return value;
        }

        @Override
        public BigDecimal toInch(BigDecimal value) {
            return value.multiply(new BigDecimal("12"));
        }

        @Override
        public BigDecimal toKilometer(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0003048"));
        }

        @Override
        public BigDecimal toMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.3048"));
        }

        @Override
        public BigDecimal toMile(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0001893939393939394"));
        }

        @Override
        public BigDecimal toMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("304.8"));
        }

        @Override
        public BigDecimal toYard(BigDecimal value) {
            return value.multiply(new BigDecimal("0.3333333333333333"));
        }
    },
    INCH {
        @Override
        public BigDecimal convert(BigDecimal value, LengthUnit lengthUnit) {
            return lengthUnit.toInch(value);
        }

        @Override
        public BigDecimal toCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("2.54"));
        }

        @Override
        public BigDecimal toDecimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.254"));
        }

        @Override
        public BigDecimal toFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0833333333333333"));
        }

        @Override
        public BigDecimal toInch(BigDecimal value) {
            return value;
        }

        @Override
        public BigDecimal toKilometer(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0000254"));
        }

        @Override
        public BigDecimal toMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0254"));
        }

        @Override
        public BigDecimal toMile(BigDecimal value) {
            return value.multiply(new BigDecimal("0.00001578282828282828"));
        }

        @Override
        public BigDecimal toMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("25.4"));
        }

        @Override
        public BigDecimal toYard(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0277777777777778"));
        }
    },
    KILOMETER {
        @Override
        public BigDecimal convert(BigDecimal value, LengthUnit lengthUnit) {
            return lengthUnit.toKilometer(value);
        }

        @Override
        public BigDecimal toCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("100000"));
        }

        @Override
        public BigDecimal toDecimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("10000"));
        }

        @Override
        public BigDecimal toFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("3280.839895013123"));
        }

        @Override
        public BigDecimal toInch(BigDecimal value) {
            return value.multiply(new BigDecimal("39370.07874015748"));
        }

        @Override
        public BigDecimal toKilometer(BigDecimal value) {
            return value;
        }

        @Override
        public BigDecimal toMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("1000"));
        }

        @Override
        public BigDecimal toMile(BigDecimal value) {
            return value.multiply(new BigDecimal("0.621371192237334"));
        }

        @Override
        public BigDecimal toMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("1000000"));
        }

        @Override
        public BigDecimal toYard(BigDecimal value) {
            return value.multiply(new BigDecimal("1093.613298337708"));
        }
    },
    METER {
        @Override
        public BigDecimal convert(BigDecimal value, LengthUnit lengthUnit) {
            return lengthUnit.toMeter(value);
        }

        @Override
        public BigDecimal toCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("100"));
        }

        @Override
        public BigDecimal toDecimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("10"));
        }

        @Override
        public BigDecimal toFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("3.280839895013123"));
        }

        @Override
        public BigDecimal toInch(BigDecimal value) {
            return value.multiply(new BigDecimal("39.37007874015748"));
        }

        @Override
        public BigDecimal toKilometer(BigDecimal value) {
            return value.multiply(new BigDecimal("0.001"));
        }

        @Override
        public BigDecimal toMeter(BigDecimal value) {
            return value;
        }

        @Override
        public BigDecimal toMile(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000621371192237334"));
        }

        @Override
        public BigDecimal toMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("1000"));
        }

        @Override
        public BigDecimal toYard(BigDecimal value) {
            return value.multiply(new BigDecimal("1.093613298337708"));
        }
    },
    MILE {
        @Override
        public BigDecimal convert(BigDecimal value, LengthUnit lengthUnit) {
            return lengthUnit.toMile(value);
        }

        @Override
        public BigDecimal toCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("160934.4"));
        }

        @Override
        public BigDecimal toDecimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("16093.44"));
        }

        @Override
        public BigDecimal toFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("5280"));
        }

        @Override
        public BigDecimal toInch(BigDecimal value) {
            return value.multiply(new BigDecimal("63360"));
        }

        @Override
        public BigDecimal toKilometer(BigDecimal value) {
            return value.multiply(new BigDecimal("1.609344"));
        }

        @Override
        public BigDecimal toMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("1609.344"));
        }

        @Override
        public BigDecimal toMile(BigDecimal value) {
            return value;
        }

        @Override
        public BigDecimal toMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("1609344"));
        }

        @Override
        public BigDecimal toYard(BigDecimal value) {
            return value.multiply(new BigDecimal("1760"));
        }
    },
    MILLIMETER {
        @Override
        public BigDecimal convert(BigDecimal value, LengthUnit lengthUnit) {
            return lengthUnit.toMillimeter(value);
        }

        @Override
        public BigDecimal toCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.1"));
        }

        @Override
        public BigDecimal toDecimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.01"));
        }

        @Override
        public BigDecimal toFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0032808398950131"));
        }

        @Override
        public BigDecimal toInch(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0393700787401575"));
        }

        @Override
        public BigDecimal toKilometer(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000001"));
        }

        @Override
        public BigDecimal toMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.001"));
        }

        @Override
        public BigDecimal toMile(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000000621371192237334"));
        }

        @Override
        public BigDecimal toMillimeter(BigDecimal value) {
            return value;
        }

        @Override
        public BigDecimal toYard(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0010936132983377"));
        }
    },
    YARD {
        @Override
        public BigDecimal convert(BigDecimal value, LengthUnit lengthUnit) {
            return lengthUnit.toYard(value);
        }

        @Override
        public BigDecimal toCentimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("91.44"));
        }

        @Override
        public BigDecimal toDecimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("9.144"));
        }

        @Override
        public BigDecimal toFoot(BigDecimal value) {
            return value.multiply(new BigDecimal("3"));
        }

        @Override
        public BigDecimal toInch(BigDecimal value) {
            return value.multiply(new BigDecimal("36"));
        }

        @Override
        public BigDecimal toKilometer(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0009144"));
        }

        @Override
        public BigDecimal toMeter(BigDecimal value) {
            return value.multiply(new BigDecimal("0.9144"));
        }

        @Override
        public BigDecimal toMile(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0005681818181818182"));
        }

        @Override
        public BigDecimal toMillimeter(BigDecimal value) {
            return value.multiply(new BigDecimal("914.4"));
        }

        @Override
        public BigDecimal toYard(BigDecimal value) {
            return value;
        }
    };

    public BigDecimal toCentimeter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toDecimeter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toFoot(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toInch(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toKilometer(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toMeter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toMile(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toMillimeter(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toYard(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal convert(BigDecimal value, LengthUnit lengthUnit) {
        throw new AbstractMethodError();
    }
}
