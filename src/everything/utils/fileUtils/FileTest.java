package everything.utils.fileUtils;

import org.apache.commons.io.FilenameUtils;

import java.io.*;

/**
 * User: Makar Kalancha
 * Date: 25/04/14
 * Time: 1:01 PM
 */
public class FileTest {
    public static void main(String[] args) {
//        String s = "d:\\testMe\\%s.xml";
//        File file = new File(s);
//        System.out.println(file.exists());
//        System.out.println(file.getParentFile());
//        System.out.println(file.getParentFile().exists());
//        file.getParentFile().mkdirs();
//        System.out.println(file.getParentFile().exists());

        String filePath = "e:\\hello";
        String filePath1 = "e:\\_hello.txt";
        String filePath2 = "e:\\688885d3df6a19bbc8c827419650ca75(2)";
        String filePath3 = "e:\\688885d3df6a19bbc8c827419650ca75.jpg";
        String filePath4 = "e:\\ASP Export Web Service";




        File file = new File(filePath);
        File file1 = new File(filePath2);
        File file2 = new File(filePath4);
//        try (
//                InputStream is = new BufferedInputStream(new FileInputStream(file));
//                InputStream is1 = new BufferedInputStream(new FileInputStream(file1));
//                InputStream is2 = new BufferedInputStream(new FileInputStream(file2));
//        ) {
//            AutoDetectParser parser = new AutoDetectParser();
//            Detector detector = parser.getDetector();
//            Metadata md = new Metadata();
//            md.add(Metadata.RESOURCE_NAME_KEY, filePath);
//            MediaType mediaType = detector.detect(is, md);
//            System.out.println(mediaType.toString());
//
//            md.add(Metadata.RESOURCE_NAME_KEY, filePath2);
//            mediaType = detector.detect(is1, md);
//            System.out.println(mediaType.toString());
//
//            md.add(Metadata.RESOURCE_NAME_KEY, filePath4);
//            mediaType = detector.detect(is2, md);
//            System.out.println(mediaType.toString());
//        }catch(IOException e){
//            e.printStackTrace();
//        }


//        MimeUtil2 mimeUtil = new MimeUtil2();
//        mimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
//        String mimeType = MimeUtil2.getMostSpecificMimeType(mimeUtil.getMimeTypes(filePath)).toString();
//        System.out.println(mimeType);
//        String mimeType1 = MimeUtil2.getMostSpecificMimeType(mimeUtil.getMimeTypes(filePath1)).toString();
//        System.out.println(mimeType1);

//        String ext1 = URLConnection.guessContentTypeFromName(filePath);
//        System.out.println(ext1);
//        String ext2 = URLConnection.guessContentTypeFromName(filePath1);
//        System.out.println(ext2);

//        File file = new File(filePath);
//        File file1 = new File(filePath1);
//        try (
//                InputStream is = new BufferedInputStream(new FileInputStream(file));
//                InputStream is1 = new BufferedInputStream(new FileInputStream(file1));
//        ){
//            String mimeType = URLConnection.guessContentTypeFromStream(is);
//            System.out.println(mimeType);
//
//            String mimeType1 = URLConnection.guessContentTypeFromStream(is1);
//            System.out.println(mimeType1);
//        }catch(IOException e){
//            e.printStackTrace();
//        }

//        FileDataSource ds = new FileDataSource(filePath);
//        String contentType = ds.getContentType();
//        System.out.println("1-The MIME type of the file e:\\hello is: " + contentType);
//
//        FileTypeMap fileTypeMap = FileTypeMap.getDefaultFileTypeMap();
//        String fileTypeMapST = fileTypeMap.getContentType(filePath);
//        System.out.println("2-The MIME type of the file e:\\hello is: " + fileTypeMapST);
//
        String extension = FilenameUtils.getExtension(filePath);
        System.out.println("3:>"+extension+"<");
        String extension1 = FilenameUtils.getExtension(filePath1);
        System.out.println("4:>"+extension1+"<");
//
//        String extension2 = com.google.common.io.Files.getFileExtension(filePath);
//        System.out.println("5:>"+extension2+"<");
//        String extension3 = com.google.common.io.Files.getFileExtension(filePath1);
//        System.out.println("6:>"+extension3+"<");
//
//        try{
//            java.nio.file.Path path4 = java.nio.file.Paths.get(filePath);
//            String extension4 = java.nio.file.Files.probeContentType(path4);
//            System.out.println("7:>"+extension4+"<");
//            String extension5 = com.google.common.io.Files.getFileExtension(filePath1);
//            System.out.println("8:>"+extension5+"<");
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//
//        File file6 = new File(filePath);
//        String s6 = new MimetypesFileTypeMap().getContentType(file6);
//        System.out.println("9:>"+s6+"<");
//        File file7 = new File(filePath1);
//        String s7 = new MimetypesFileTypeMap().getContentType(file7);
//        System.out.println("10:>"+s7+"<");
    }
}
