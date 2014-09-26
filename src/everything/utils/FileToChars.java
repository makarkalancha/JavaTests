package everything.utils;

import java.io.*;

/**
 * User: Makar Kalancha
 * Date: 13/06/14
 * Time: 2:15 PM
 */
public class FileToChars {
    public static void main(String[] args) {
        String filePath = "D:\\\\Tasks\\\\066_analytics\\\\20140613\\\\interbike2013\\\\reports\\\\##DeviceAggregate1.txt";
        File file = new File(filePath);
        try {
            String fileContent = readFile(file);
            System.out.println(fileContent);
            String[][] string2DArray = convertStringToBytes(fileContent, "UTF8");
//            for(int i =0;i<string2DArray.length;i++) {
//                for(int j = 0; j < string2DArray[i].length;j++) {
//                    String token = " -> ";
//                    if (j + 1 == string2DArray[i].length){
//                        token = "";
//                    }
//                    System.out.print(string2DArray[i][j] + token);
//                }
//                System.out.println();
//            }
//
//            Path path = Paths.get(filePath);
//            byte[] bytes = Files.readAllBytes(path);
//            for(int i = 0 ; i < bytes.length;i++){
//                System.out.println(Integer.toHexString(bytes[i]));
//            }

            System.out.println(escapeBackSlash(fileContent));
            System.out.println(escapeBackSlash(null));
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    protected static String escapeBackSlash(String string) {
        return string.replace("\\", "\\\\");
    }

    private static String readFile(File file) throws IOException{
        String result = "";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        try{
            while((line = br.readLine()) != null) {
                result += line;
            }
        } finally {
            br.close();
        }
        return result;
    }

    private static String[][] convertStringToBytes(String stringToConvert, String encoding) throws UnsupportedEncodingException {
        String[][] stringArray = new String[stringToConvert.length()][];
        for(int i = 0; i < stringToConvert.length();i++) {
            String stringChar = Character.toString(stringToConvert.charAt(i));
            stringArray[i] = new String[]{stringChar, Integer.toHexString(stringChar.getBytes(encoding)[0])};
        }
        return stringArray;
    }


}
