package com.everything.unit_measurement.converters;

import java.math.BigDecimal;

/**
 * User: Makar Kalancha
 * Date: 28/10/2017
 * Time: 17:39
 */
public enum WeightUnit{
    GRAM {
        @Override
        public BigDecimal toGram(BigDecimal value) {
            return value;
        }

        @Override
        public BigDecimal toKilogram(BigDecimal value) {
            return value.multiply(new BigDecimal("0.001"));
        }

        @Override
        public BigDecimal toMilligram(BigDecimal value) {
            return value.multiply(new BigDecimal("1000"));
        }

        @Override
        public BigDecimal toOunce(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0352739619495804"));
        }

        @Override
        public BigDecimal toPound(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0022046226218488"));
        }

        @Override
        public BigDecimal toTonne(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000001"));
        }

        @Override
        public BigDecimal convert(BigDecimal value, WeightUnit weightUnit) {
            return weightUnit.toGram(value);
        }
    },
    KILOGRAM {
        @Override
        public BigDecimal toGram(BigDecimal value) {
            return value.multiply(new BigDecimal("1000"));
        }

        @Override
        public BigDecimal toKilogram(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toMilligram(BigDecimal value) {
            return value.multiply(new BigDecimal("1000000"));
        }

        @Override
        public BigDecimal toOunce(BigDecimal value) {
            return value.multiply(new BigDecimal("35.27396194958041"));
        }

        @Override
        public BigDecimal toPound(BigDecimal value) {
            return value.multiply(new BigDecimal("2.204622621848776"));
        }

        @Override
        public BigDecimal toTonne(BigDecimal value) {
            return value.multiply(new BigDecimal("0.001"));
        }

        @Override
        public BigDecimal convert(BigDecimal value, WeightUnit weightUnit) {
            return weightUnit.toKilogram(value);
        }
    },
    MILLIGRAM {
        @Override
        public BigDecimal toGram(BigDecimal value) {
            return value.multiply(new BigDecimal("0.001"));
        }

        @Override
        public BigDecimal toKilogram(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000001"));
        }

        @Override
        public BigDecimal toMilligram(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toOunce(BigDecimal value) {
            return value.multiply(new BigDecimal("0.00003527396194958041"));
        }

        @Override
        public BigDecimal toPound(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000002.204622621848776"));
        }

        @Override
        public BigDecimal toTonne(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000000001"));
        }

        @Override
        public BigDecimal convert(BigDecimal value, WeightUnit weightUnit) {
            return weightUnit.toMilligram(value);
        }
    },
    OUNCE {
        @Override
        public BigDecimal toGram(BigDecimal value) {
            return value.multiply(new BigDecimal("28.349523125"));
        }

        @Override
        public BigDecimal toKilogram(BigDecimal value) {
            return value.multiply(new BigDecimal("0.028349523125"));
        }

        @Override
        public BigDecimal toMilligram(BigDecimal value) {
            return value.multiply(new BigDecimal("28349.523125"));
        }

        @Override
        public BigDecimal toOunce(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toPound(BigDecimal value) {
            return value.multiply(new BigDecimal("0.0625"));
        }

        @Override
        public BigDecimal toTonne(BigDecimal value) {
            return value.multiply(new BigDecimal("0.000028349523125"));
        }

        @Override
        public BigDecimal convert(BigDecimal value, WeightUnit weightUnit) {
            return weightUnit.toOunce(value);
        }
    },
    POUND {
        @Override
        public BigDecimal toGram(BigDecimal value) {
            return value.multiply(new BigDecimal("453.59237"));
        }

        @Override
        public BigDecimal toKilogram(BigDecimal value) {
            return value.multiply(new BigDecimal("0.45359237"));
        }

        @Override
        public BigDecimal toMilligram(BigDecimal value) {
            return value.multiply(new BigDecimal("453592.37"));
        }

        @Override
        public BigDecimal toOunce(BigDecimal value) {
            return value.multiply(new BigDecimal("16"));
        }

        @Override
        public BigDecimal toPound(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal toTonne(BigDecimal value) {
            return value.multiply(new BigDecimal("0.00045359237"));
        }

        @Override
        public BigDecimal convert(BigDecimal value, WeightUnit weightUnit) {
            return weightUnit.toPound(value);
        }
    },
    TONNE {
        @Override
        public BigDecimal toGram(BigDecimal value) {
            return value.multiply(new BigDecimal("1000000"));
        }

        @Override
        public BigDecimal toKilogram(BigDecimal value) {
            return value.multiply(new BigDecimal("1000"));
        }

        @Override
        public BigDecimal toMilligram(BigDecimal value) {
            return value.multiply(new BigDecimal("1000000000"));
        }

        @Override
        public BigDecimal toOunce(BigDecimal value) {
            return value.multiply(new BigDecimal("35273.96194958041"));
        }

        @Override
        public BigDecimal toPound(BigDecimal value) {
            return value.multiply(new BigDecimal("2204.622621848776"));
        }

        @Override
        public BigDecimal toTonne(BigDecimal value) {
            return value.multiply(BigDecimal.ONE);
        }

        @Override
        public BigDecimal convert(BigDecimal value, WeightUnit weightUnit) {
            return weightUnit.toTonne(value);
        }
    };

    public BigDecimal toGram(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toKilogram(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toMilligram(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toOunce(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toPound(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal toTonne(BigDecimal value) {
        throw new AbstractMethodError();
    }

    public BigDecimal convert(BigDecimal value, WeightUnit weightUnit) {
        throw new AbstractMethodError();
    }
}
