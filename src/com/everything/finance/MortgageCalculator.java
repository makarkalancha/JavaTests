package com.everything.finance;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by mcalancea
 * Date: 18 Jul 2018
 * Time: 08:51
 */
public class MortgageCalculator {
    private static final int SCALE = 6;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter principal: ");
//        BigDecimal principal = scanner.nextBigDecimal();
        BigDecimal principal = new BigDecimal("206000");

//        System.out.println("Enter Yearly Interest Rate: ");
//        BigDecimal rate = scanner.nextBigDecimal()
        BigDecimal rate = new BigDecimal("2.64")
                .divide(new BigDecimal("100"), SCALE, BigDecimal.ROUND_HALF_UP)
//                .divide(new BigDecimal("12"), SCALE, BigDecimal.ROUND_HALF_UP)
                .divide(new BigDecimal("26"), SCALE, BigDecimal.ROUND_HALF_UP);

//        System.out.println("Enter Term (years): ");
//        int term = scanner.nextInt() * 12; //term in month
        int term = 25
//                * 12
                * 26
                ; //term in month

        BigDecimal variable = BigDecimal.ONE.subtract(new BigDecimal(Double.toString(Math.pow(1 + rate.doubleValue(), -term))));

        BigDecimal payment = principal.multiply(rate).divide(variable, SCALE, BigDecimal.ROUND_HALF_UP);
        System.out.println("Payment: " + payment);
    }
}
