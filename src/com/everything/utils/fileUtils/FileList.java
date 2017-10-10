package com.everything.utils.fileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 09/09/14
 * Time: 12:54 PM
 */
public class FileList {

    public static void main(String[] args) {
//        writeFileNamesToAFile("D:\\SRC\\PHP\\1.9.2\\application\\Helpers\\Tasks", "list.txt");
        writeFileNamesToAFile("z_lang", "jsonS.txt");
    }

    public static List<File> getFileList(String sourceFolderName){
        List<File> fileList = new ArrayList<>();
        final File sourceFolder = new File(sourceFolderName);
        if(sourceFolder.isDirectory()) {
            fileList.addAll(Arrays.asList(sourceFolder.listFiles()));
        }
        return fileList;
    }

    public static void writeFileNamesToAFile(String sourceDirectory, String destinationFile) {
//        String pathDir = "D:\\Tasks\\070_7243_ivew2014_dt\\2-data\\handouts_session\\VEW 2014 handouts_20140911_1741\\VEW 2014 handouts";
//        String pathDir = "D:\\SRC\\PHP\\1.9.2\\migrations";
        String pathDir = sourceDirectory;
        String filename = destinationFile;

        File dir = new File(pathDir);
        File[] files = dir.listFiles();

        File listFile = new File(dir.getParentFile(), filename);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(listFile));
            for (File file : files) {
                pw.println(file.getName());
            }
        }catch(IOException e) {
            e.getMessage();
        }finally {
            if(pw != null){
                pw.flush();
                pw.close();
            }
        }

    }
}
