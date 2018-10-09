package com.everything.strings;

import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by mcalancea
 * Date: 01 Aug 2018
 * Time: 16:03
 */
public class ChangeKeyboard {
    public static void main(String[] args) {
        try {
            System.out.println("0 for ru, 1 for US, 2 for UK, 3 for FRENCH, 4 to quit");
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(Locale.getDefault());

            InputContext it = InputContext.getInstance();
            boolean fContinue = true;
            while (fContinue == true) {
                String s = b.readLine();
                int number = -1;

                try {
                    number = Integer.parseInt(s);
                }catch (NumberFormatException e){
                    System.err.println("try again");
                }

                if (number == 0) {
                    if (it.selectInputMethod(new Locale("ru", "RU"))) {
                        System.out.println("Locale successfully changed to Russian");
                    } else {
                        System.out.println("Locale change failure");
                    }
                } else if (number == 1) {
//                    if (it.selectInputMethod(new Locale("en", "US", "WIN"))) {
                    if (it.selectInputMethod(new Locale("en", "US"))) {
                        System.out.println("Locale successfully changed to US English");
                    } else {
                        System.out.println("Locale change failure");
                    }
                } else if (number == 2) {
                    if (it.selectInputMethod(new Locale("en", "GB")))
                        System.out.println("Locale successfully changed to GB English");
                    else
                        System.out.println("Locale change failure");
                } else if (number == 3) {
                    if (it.selectInputMethod(new Locale("fr", "FR")))
                        System.out.println("Locale successfully changed to FRENCH");
                    else
                        System.out.println("Locale change failure");
                } else if (number == 4) {
                    fContinue = false;
                }
            }
        } catch (IOException e) {
            //handle exception here
        }
    }
}
