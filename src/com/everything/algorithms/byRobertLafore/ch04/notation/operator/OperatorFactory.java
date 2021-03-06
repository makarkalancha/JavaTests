package com.everything.algorithms.byRobertLafore.ch04.notation.operator;

import com.everything.algorithms.byRobertLafore.ch04.notation.Operator;

/**
 * Created by mcalancea on 23 Jun 2016.
 */
public class OperatorFactory {
    public static Operator buildOperator(String operator){
        if(operator.equals("+")){
            return new Add();
        } else if(operator.equals("-")){
            return new Substract();
        } else if(operator.equals("*")){
            return new Multiply();
        } else if(operator.equals("/")){
            return new Divide();
        }
        return null;
    }
}
