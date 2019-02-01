package com.everything.null_tests;

import com.everything.algorithms.byRobertLafore.ch04.notation.Operator;
import com.everything.algorithms.byRobertLafore.ch04.notation.operator.Add;
import com.everything.algorithms.byRobertLafore.ch04.notation.operator.Substract;

/**
 * Created by Makar Kalancha
 * Date: 10 Aug 2017
 * Time: 15:43
 */
public class StringNull {
    public static void main(String[] args) {
//        String any = "any";
        String any = null;
        ExceptionString exceptionString = new ExceptionString(null);
//        System.out.println(exceptionString.getCause().equals(any));
//        System.out.println(any.equals(exceptionString.getCause()));
//        System.out.println(any.toLowerCase());

        Class<? extends Operator> clazz1 = Add.class;
        Class<? extends Operator> clazz2 = Substract.class;
        Class<? extends Operator> clazz3 = Operator.class;
        System.out.println(clazz1.getName());
        System.out.println(clazz1.getCanonicalName());
        System.out.println(clazz1.getSimpleName());
        System.out.println("clazz1 == Add.class:" + (clazz1 == Add.class));
        System.out.println("clazz1 == Substract.class:" + (clazz1 == Substract.class));
        System.out.println("clazz1 == Operator.class:" + (clazz1 == Operator.class));
        System.out.println("clazz1 == clazz2:" + (clazz1 == clazz2));
        System.out.println("clazz1 == clazz3:" + (clazz1 == clazz3));

    }

    private static class ExceptionString{
        private final String cause;

        public ExceptionString(String cause) {
            this.cause = cause;
        }

        public String getCause() {
            return cause;
        }
    }
}
