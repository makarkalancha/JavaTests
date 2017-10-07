package com.everything.null_tests;

/**
 * Created by Makar Kalancha
 * Date: 10 Aug 2017
 * Time: 15:43
 */
public class StringNull {
    public static void main(String[] args) {
        String any = "any";
        ExceptionString exceptionString = new ExceptionString(null);
//        System.out.println(exceptionString.getCause().equals(any));
        System.out.println(any.equals(exceptionString.getCause()));
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
