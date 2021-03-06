package com.everything.algorithms.byRobertLafore.ch04.notation;

import com.everything.algorithms.byRobertLafore.ch04.collection.DequeStack;
import com.everything.algorithms.byRobertLafore.ch04.collection.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcalancea on 21 Jun 2016.
 */
public class ReversePolishNotation {
    private Stack<String> operatorStack = new DequeStack<>(); //operator +-... and operand 3, 2, 4, a, b, c ...
    private List<String> operandOperatorList = new ArrayList<>();
    private String allowedCharacters = "/*-+()";
    private char decimalSeparator;
    private String arithmeticNotation;

    public ReversePolishNotation(String arithmeticNotation, char decimalSeparator){
        this.arithmeticNotation = arithmeticNotation;
        this.decimalSeparator = decimalSeparator;
    }

    public char getDecimalSeparator() {
        return decimalSeparator;
    }

    public void setDecimalSeparator(char decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public String getArithmeticNotation() {
        return arithmeticNotation;
    }

    public void setArithmeticNotation(String arithmeticNotation) {
        this.arithmeticNotation = arithmeticNotation;
    }

    private void convertStringToOperandList(){
        StringBuilder operand = new StringBuilder();
        for (int i = 0; i < arithmeticNotation.length(); i++) {
            char charInString = arithmeticNotation.charAt(i);
            if (allowedCharacters.indexOf(charInString) > -1) {

                operandOperatorList.add(operand.toString());
                operand = new StringBuilder();

                operandOperatorList.add(Character.toString(charInString));

            } else {
                operand.append(charInString);
            }
        }
        operandOperatorList.add(operand.toString());
    }

    public String convertToReversePolishNotation(){
        convertStringToOperandList();
        System.out.println(operandOperatorList);

        StringBuilder reversePolishNotation = new StringBuilder();
        for (int i = 0; i < operandOperatorList.size(); i++) {
            String element = operandOperatorList.get(i);
            if (element.equals("+") ||
                    element.equals("-") ||
                    element.equals("*") ||
                    element.equals("/") ||
                    element.equals("(")
                    ) {
                operatorStack.push(element);
            } else if (element.equals(")")) {
                if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                    operatorStack.pop(); //remove "("
                }
                if (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    reversePolishNotation.append(operatorStack.pop());
                }
            } else {
                reversePolishNotation.append(element);

                if (!operatorStack.isEmpty() && operandOperatorList.size() > (i + 1)) {
                    String nextOperand = operandOperatorList.get(i + 1);
                    if (operatorStack.peek().equals("+") || operatorStack.peek().equals("-")) {
                        if (!nextOperand.equals("(") &&
                                !nextOperand.equals("*") &&
                                !nextOperand.equals("/")) {
                            reversePolishNotation.append(operatorStack.pop());
                        }
                    }else if (!nextOperand.equals("(") && (operatorStack.peek().equals("*") || operatorStack.peek().equals("/"))) {
                        reversePolishNotation.append(operatorStack.pop());
                    }
                }
            }

            if (i == (operandOperatorList.size() - 1)) {
                while(!operatorStack.isEmpty()){
                    reversePolishNotation.append(operatorStack.pop());
                }
            }
        }
        System.out.println(">>>reversePolishNotation: " + reversePolishNotation.toString());
        return reversePolishNotation.toString();
    }

}
