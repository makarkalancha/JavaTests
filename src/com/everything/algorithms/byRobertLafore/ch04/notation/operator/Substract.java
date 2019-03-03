package com.everything.algorithms.byRobertLafore.ch04.notation.operator;

import com.everything.algorithms.byRobertLafore.ch04.notation.Operator;

/**
 * Created by mcalancea on 23 Jun 2016.
 */
public class Substract implements Operator {
    @Override
    public String getOperatorSymbol() {
        return "-";
    }

    @Override
    public int getPrecedence() {
        return 1;
    }
}
