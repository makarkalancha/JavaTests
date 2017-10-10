package com.everything.java8tests.functionalprogramming.ch04.calculator;

/**
 * User: Makar Kalancha
 * Date: 22/01/2016
 * Time: 20:53
 */
public class Asset {
    public enum AssetType {
        BOND, STOCK
    };
    private final AssetType type;
    private final int value;
    public Asset(final AssetType assetType, final int assetValue) {
        type = assetType;
        value = assetValue;
    }
    public AssetType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
