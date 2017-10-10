package com.everything.algorithms.byRobertLafore.ch04;

import java.util.LinkedList;

/**
 * User: Makar Kalancha
 * Date: 20/06/14
 * Time: 9:35 AM
 */
public class StackDemo {
    public static void main(String[] args) {
//        String word = "a(b[b{c}d]e)f";
        String word = "a(b[b{c}d)e)f";
        LinkedList<Character> characterStack = new LinkedList<>();
        char[] chars = word.toCharArray();
        boolean isCorrect = true;
        for(char c : chars){
            switch (c){
                case '(':
                case '[':
                case '{':
                    characterStack.addFirst(c);
                    break;
                case ')':
                case ']':
                case '}': {
                    char cPoppped = characterStack.pollFirst();
                    if (
                        (c == ')' && cPoppped != '(') ||
                        (c == ']' && cPoppped != '[') ||
                        (c == '}' && cPoppped != '{')
                    ){
                        isCorrect = false;
                        System.out.println("Error: incorrect sequence");
                    }
                    break;
                }
                default: break;
            }
        }

        if(characterStack.size() > 0 || !isCorrect){
            System.out.println("Error: incorrect sequence");
        } else{
            System.out.println("Correct");
        }
    }


}
