package everything.fileUtils;

import java.io.*;

/**
 * User: Makar Kalancha
 * Date: 09/09/14
 * Time: 12:54 PM
 */
public class FileList {
    public static void main(String[] args) {
//        String pathDir = "D:\\Tasks\\070_7243_ivew2014_dt\\2-data\\handouts_session\\VEW 2014 handouts_20140911_1741\\VEW 2014 handouts";
//        String pathDir = "D:\\SRC\\PHP\\1.9.2\\migrations";
        String pathDir = "D:\\SRC\\PHP\\1.9.2\\application\\Helpers\\Tasks";
        String filename = "list.txt";

        File dir = new File(pathDir);
        File[] files = dir.listFiles();

        File listFile = new File(dir.getParentFile(), filename);
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            pw = new PrintWriter(new FileWriter(listFile));
//            br = new BufferedReader(new FileReader(listFile));
            for (File file : files) {
                //            System.out.println(file.getName());
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
