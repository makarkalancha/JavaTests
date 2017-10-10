package com.everything.utils.fileUtils;

import java.io.File;
import java.io.IOException;

/**
 * User: Makar Kalancha
 * Date: 22/09/14
 * Time: 2:21 PM
 */
public class FileReadCharacters {
    public static void main(String[] args) {
//        String fileSrcPath = "D:\\Tasks\\066_analytics\\20140922\\HourlyQrActionsAggregate.txt";
//        String fileDestPath = "D:\\Tasks\\066_analytics\\20140922\\HourlyQrActionsAggregate_bytes.txt";
//        byte[] bytes = new byte[(int) new File(fileSrcPath).length()];
//        try{
//            FileUtils.readFileByBytes(fileSrcPath,bytes);
//            for(byte byteOne : bytes){
//                FileUtils.writeFile(fileDestPath,Byte.toString(byteOne),true);
//            }
//        }catch(IOException e) {
//            e.printStackTrace();
//        }

        String fileToRead = "D:\\Tasks\\066_analytics\\20140922\\test_string1.txt";
        byte[] bytes1 = new byte[(int) new File(fileToRead).length()];
        try{
            FileUtils.readFileByBytes(fileToRead,bytes1);
            String resultString = "";
            for(byte byteOne : bytes1) {
                resultString += (char) byteOne;
            }
            System.out.println(">>");
            String resultNew = resultString.replace("\\", "\\\\");
            System.out.println(resultNew);
//            String resultNew1 = Matcher.quoteReplacement(resultString);
            String resultNew1 = resultString.replaceAll("\r", "\\\\r");
//            String resultNew1 = resultString.replaceAll("\\\\", "\\\\\\\\\\");
            System.out.println("resultNew1:" + resultNew1);

            String resultNew2 = resultString.replaceAll("\\x0d", "\\\\r");
//            String resultNew1 = resultString.replaceAll("\\\\", "\\\\\\\\\\");
            System.out.println("resultNew2:" + resultNew2);

//            String resultNew3 = resultString.replaceAll("\\x92", "\\\\");
            String resultNew3 = cleanString(resultString);
//            String resultNew1 = resultString.replaceAll("\\\\", "\\\\\\\\\\");
            System.out.println("resultNew3:"+resultNew3);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

      
    public static String cleanString(String str) {
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(ch == 13) {
                sb.append("\\\\r");
            } else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
