package com.everything.job_tests;

/**
 * User: Makar Kalancha
 * Date: 03/01/2019
 * Time: 10:20
 */
public class Stack
{
    private static final int MAX_SIZE = 10;

    private Long[] stack = new Long[MAX_SIZE];
    private int iterator = 0;

    public void push(Long i) {
        int newIterator = iterator + 1;
        if (newIterator < MAX_SIZE + 1) {
            stack[iterator++] = i;
        }
    }

    public Long pop() {
        int newIterator = --iterator;
        if(newIterator < 0){
            newIterator = 0;
        }
        return stack[newIterator];
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
//        stack.push(5L);
        stack.push(1L);
        stack.push(2L);
        stack.push(3L);
        stack.push(4L);
        stack.push(5L);
        stack.push(6L);
        stack.push(7L);
        stack.push(8L);
        stack.push(9L);
        stack.push(10L);
        stack.push(21L);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}