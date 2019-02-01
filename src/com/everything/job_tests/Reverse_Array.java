package com.everything.job_tests;

/**
 * User: Makar Kalancha
 * Date: 03/01/2019
 * Time: 10:15
 */
public class Reverse_Array
{
    public static char[] reverseArray(char[] array) {
        char[] result = new char[array.length];
        for (int i = array.length - 1, j = 0; i > -1 && j < result.length; i--, j++) {
            result[j] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        char[] input = {'H','e','l','l','o'};
        System.out.println(reverseArray(input));
    }
}