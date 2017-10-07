package com.everything.utils.fileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * User: Makar Kalancha
 * Date: 22/09/14
 * Time: 10:19 AM
 */
public class FileUtils {
    public static String readFile(File file) throws IOException {
        String result = "";
        String line = "";
        try(BufferedReader br = new BufferedReader(new FileReader(file));){
            while((line = br.readLine()) != null) {
                result += line;
            }
        }
        return result;
    }

    public static void readFileIntoLineCollection(String filePath, Collection<String> fileLines) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath));) {
            String line;
            while ((line = br.readLine()) != null) {
                fileLines.add(line);
            }
        }
    }

    public static void readFileIntoString(String filePath, StringBuilder fileInStringBuilder) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath));) {
            String line;
            while ((line = br.readLine()) != null) {
                fileInStringBuilder.append(line);
            }
        }
    }

    public static void readFileByBytes(String filePath, byte[] bytesArr) throws IOException {
        try(FileInputStream fis = new FileInputStream(new File(filePath));) {
            fis.read(bytesArr);
        }
    }

    public static void writeFile(String filePath, String text, boolean isAppended) throws IOException {
        try(PrintWriter pw = new PrintWriter(new FileWriter(filePath, isAppended));) {
            pw.println(text);
        }
//        pw.flush();
//        pw.close();
    }



}
