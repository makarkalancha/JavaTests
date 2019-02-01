package com.everything.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mcalancea on 2016-03-07.
 */
public class RegexAutocomplete {

    private static String[] strings = {
            "Daniel", "Dustin", "David", "Damascus", "Russ", "UpdateAttributeAbstractHelper",
            "хлеб", "молоко", "масло раст", "масло слив", "помидоры зел", "помидоры желт"
        };


    public static void main(String[] args) {
//        String input = "updaatthe";
//        String input = "UpdaAttHe";
        String input = "х";
        //        String input = "UpdaAttHe";
        System.out.println("input:" + input);
        List<String> autocomplete = autoComplete(input);
        System.out.println(autocomplete);
    }

    //http://stackoverflow.com/questions/196830/what-is-the-easiest-best-most-correct-way-to-iterate-through-the-characters-of-a
    //Test 1: charAt + String --> 3138msec
    public static List<String> autoComplete(String input) {
        List<String> result = new ArrayList<>();

        StringBuilder regex = new StringBuilder();
        for(int i = 0;i<input.length();i++) {
            regex.append(input.charAt(i));
            regex.append(".*");
        }


        //http://stackoverflow.com/questions/2469244/whats-the-difference-between-string-matches-and-matcher-matches
//        for(String string : strings){
//            if(string.toLowerCase().matches(regex.toString())){
//                result.add(string);
//            }
//        }

        Pattern pattern = Pattern.compile(regex.toString(),Pattern.CASE_INSENSITIVE);
        for(String string : strings) {
            Matcher matcher = pattern.matcher(string);
            if(matcher.find()){
                result.add(string);
            }
        }

        for (String string : result) {
            for (int i = 0; i < input.length(); i++) {

            }
        }




        return result;
    }

//BODL A PART OF STRING
//http://htmlasks.com/make_portion_of_a_text_bold_in_a_javafx_label_or_text
//    TextFlow flow = new TextFlow();
//
//    Text text1=new Text("Some Text");
//    text1.setStyle("-fx-font-weight: bold");
//
//    Text text2=new Text("Some Text");
//    text2.setStyle("-fx-font-weight: regular");
//
//    flow.getChildren().addAll(text1, text2);

}
