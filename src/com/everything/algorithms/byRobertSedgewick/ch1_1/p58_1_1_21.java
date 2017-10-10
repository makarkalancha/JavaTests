package com.everything.algorithms.byRobertSedgewick.ch1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p58_1_1_21{
    private static final String EXIT = "quit";
//    private enum COMMANDS{EXIT}
    private static final Pattern PATTERN = Pattern.compile("\\w+\\s+\\d+(\\.\\d+)?\\s+\\d+(\\.\\d+)?");
    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        p58_1_1_21 instance = new p58_1_1_21();
        String line = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        do {
            try {
                line = br.readLine();
                if(!line.equalsIgnoreCase(EXIT) && !instance.isValidString(line)) {
//                    throw new IllegalArgumentException("Format: name number number");
                    System.out.println("Format: name number number");
                } else {
                    instance.addToList(line);
                }
//                System.out.println(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            catch (IllegalArgumentException e){
//                System.out.println("another attempt: ");
//            }
        } while (!line.equalsIgnoreCase(EXIT));

        instance.printList();

    }

    public void printList(){
        System.out.println("Name\t\tPasses\t\tGoals\tTotal Points\tDivision");
        for(String s : list){
            String[] strArr = s.split("\\s");
            double goals = 0;
            double passes = 0;
            double points = 0;
            double division = 0;
            if(strArr.length == 3){
                passes = Double.parseDouble(strArr[1]);
                goals = Double.parseDouble(strArr[2]);
                points = passes + goals;
                division = passes / goals;
                System.out.println(String.format("%1$s\t\t%2$.3f\t\t%3$.3f\t\t%4$.3f\t\t%5$.3f",
                        strArr[0],passes,goals,points,division));
            }
        }

    }

    public boolean isValidString(String s){
        Matcher matcher = PATTERN.matcher(s);
        return matcher.matches();
    }

    public boolean addToList(String string) {
        return list.add(string);
    }

}
