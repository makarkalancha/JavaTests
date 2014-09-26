package everything.fileUtils;

import java.io.*;
import java.util.Collection;

/**
 * User: Makar Kalancha
 * Date: 22/09/14
 * Time: 10:19 AM
 */
public class FileUtils {
    public static void readFileIntoLineCollection(String filePath, Collection<String> fileLines) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while((line = br.readLine())!=null) {
            fileLines.add(line);
        }
        br.close();
    }

    public static void readFileIntoString(String filePath, StringBuilder fileInStringBuilder) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while((line = br.readLine())!=null) {
            fileInStringBuilder.append(line);
        }
        br.close();
    }

    public static void readFileByBytes(String filePath, byte[] bytesArr) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        fis.read(bytesArr);
        fis.close();
    }

    public static void writeFile(String filePath, String text, boolean isAppended) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(filePath, isAppended));
        pw.println(text);
        pw.flush();
        pw.close();
    }



}
