package everything.utils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Makar Kalancha
 * Date: 02/06/14
 * Time: 11:39 AM
 */
public class IOUtils {
    private File _file;
    private boolean _append = true;
//    private boolean _createNewFile = true;

    public IOUtils(String filePath, boolean append) throws IOException{
        _file = new File(filePath);
        _append = append;
        initialize();
    }

    public IOUtils(String filePath) throws IOException{
        _file = new File(filePath);
        initialize();
    }

    private void initialize() throws IOException{
        if(!_append) {
            if(_file.exists()) {
                _file = new File(prefixFile());
            }
            System.out.println("create new file:" + _file.createNewFile());
        }
    }

    private String prefixFile(){
        String fileName = _file.getName();
//        StringBuilder sb = new StringBuilder(fileName);
//        int charNumber = fileName.contains(".") ? fileName.lastIndexOf(".") : fileName.length();
//        sb.insert(charNumber, "- Copy 1");
//        return sb.toString();

        String prefix = " - Copy ";
        int prefixNumber = 1;

//        System.out.println(fileName.replaceAll("."));

        int prefixIndex = fileName.lastIndexOf(prefix);
        System.out.println(prefixIndex);
        if(prefixIndex > -1) {

            Pattern pattern = Pattern.compile(prefix + "\\d+");
            Matcher matcher = pattern.matcher(fileName);
            while(matcher.find()){
                String tmp = matcher.group();
                System.out.println(tmp);
                prefixNumber = Integer.parseInt(tmp.replace(prefix, ""));
                System.out.println(prefixNumber);
                fileName=fileName.replaceAll(prefix + "\\d+", "");
            }
            prefixNumber++;

        }
        StringBuilder sb = new StringBuilder(fileName);
        int charNumber = fileName.contains(".") ? fileName.lastIndexOf(".") : fileName.length();
        return sb.insert(charNumber, " - Copy "+prefixNumber).toString();
    }

    public static void main(String[] args) {
        Path currentPath = Paths.get("");
        System.out.println(currentPath);
        String pathString = currentPath.toAbsolutePath().toString();
        System.out.println(pathString);
        try {
            IOUtils iou = new IOUtils(pathString + "\\test.txt", false);
            iou.writeIntoFile("hello");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeIntoFile(String text) throws IOException{
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(_file, true)));
//        if(append){
            pw.println(text);
//        } else{
//
//        }

        } finally {
            pw.flush();
            pw.close();
        }
    }

    public String readFromFile() throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(_file));
        try {
            String line = "";
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } finally {
            reader.close();
        }
    }
}
