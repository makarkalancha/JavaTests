package com.test.everything.convert_files;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 18/03/14
 * Time: 11:34 AM
 */
public class ConvertFileToXml {
    private String inPath;
    private String outPath;
    String[] rules = {
//            "GetExhibData",
//            "GetExhibLibraryData",
//            "GetSeminars",
//            "GetSpeakers"
//            "GetExhibitorInfo",
//            "GetModifiedExhibitors",
//            "ValidateUser",
            "http"
    };

    public ConvertFileToXml(String in, String out){
        inPath=in;
        outPath = out;
    }

    public static void main(String[] args) {

//        String inSt = "C:\\Users\\makar\\datasink_data\\__work\\vita2014\\2014-03-18_09-49\\";
//        String inSt = "C:\\Users\\makar\\datasink_data\\__work\\vita2014\\2014-05-08_09-29\\";
//        String outSt = "D:\\Tasks\\038_6365_vita2014_sd\\2_data\\ASP\\20140508\\%s.xml";
        String inSt = "d:\\tmp\\";
        String outSt = "D:\\Tasks\\064_7176_pac2014_mm\\2-data\\20140528\\pac2014\\%s.xml";
        ConvertFileToXml converter = new ConvertFileToXml(inSt,outSt);
        try{
            converter.process();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void process() throws IOException {
        Set<String> files = filesInDirectory();
        for(String file : files){
            StringBuilder sb = readFile(file);
            sb = covertNonHtmlTag(sb);
            sb = removeSpace(sb);
            sb = newLine(sb);
            writeToFile(sb,file);
        }
    }

    private Set<String> filesInDirectory(){
        File dir = new File(inPath);
        HashSet<String> files = new HashSet<String>();
        for(File file : dir.listFiles()){
            if(isValidFile(file.getName())){
                System.out.println(file.getName());
                files.add(file.getPath());
            }
        }
        return files;
    }

    private boolean isValidFile(String fileName){
        for(String rule : rules){
            if(fileName.contains(rule)){
                return true;
            }
        }
        return false;
    }
    private StringBuilder readFile(String path) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while((line = br.readLine())!=null) {
            sb.append(line);
        }
        br.close();
        return sb;
    }

    private StringBuilder covertNonHtmlTag(StringBuilder dirty) {
//        StringBuilder clean = new StringBuilder();
//        int size = dirty.length();
//        int size = 0;
//        int count = 0;
//        do {
//            System.out.println("count: "+(++count));
//            size = dirty.length();
//            dirty = new StringBuilder(Jsoup.parse(dirty.toString()).text());
//        } while (size != dirty.length());

        dirty = new StringBuilder(StringEscapeUtils.unescapeHtml(dirty.toString()));

        return dirty;
    }

    private StringBuilder removeSpace(StringBuilder dirty){
        return new StringBuilder(dirty.toString().replaceAll(">\\s+<","><"));
    }

    private StringBuilder newLine(StringBuilder dirty){
        return new StringBuilder(dirty.toString().replaceAll("><",">\r\n<"));
    }

    private void writeToFile(StringBuilder sb, String outFile) throws IOException {
        File outPathFile = new File(outPath);
        if(!outPathFile.getParentFile().exists()) {
            outPathFile.getParentFile().mkdirs();
        }
        File file = new File(outFile);
        System.out.println(String.format(outPath, file.getName()));
        PrintWriter pw = new PrintWriter(String.format(outPath, file.getName()));
        pw.write(sb.toString());
        pw.flush();
        pw.close();
    }


}
