package com.everything.locale;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Makar Kalancha
 * Date: 27 Mar 2017
 * Time: 15:20
 */
public class MessageFormatDemo {
    private static void displayMessage(Locale currentLocale){
        System.out.println("current locale:" + currentLocale.toString());
        System.out.println();

        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
        Object[] messageArguments = {
                messages.getString("planet"),
                new Integer(7),
                new Date()
        };

        MessageFormat messageFormat = new MessageFormat("");
        messageFormat.setLocale(currentLocale);

        messageFormat.applyPattern(messages.getString("template"));
        String output = messageFormat.format(messageArguments);
        System.out.println(output);
    }
    public static void main(String[] args) {
        displayMessage(new Locale("en", "US"));
        System.out.println();
        displayMessage(new Locale("de", "DE"));
    }
}
