package com.everything;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpDownloadUtility {
    private static final int BUFFER_SIZE = 4096;

    /**
     * Downloads a file from a URL
     * @param fileURL HTTP URL of the file to be downloaded
     * @param saveDir path of the directory to save the file
     * @throws IOException
     */
    public static void downloadFile(String fileURL, String saveDir)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//        int responseCode = httpConn.getResponseCode();

        httpConn.disconnect();

        String subUrl = httpConn.getHeaderField("Location");
        System.out.println(subUrl);
        URL url1 = new URL(subUrl);
        HttpURLConnection httpConn1 = (HttpURLConnection) url1.openConnection();
        int responseCode = httpConn1.getResponseCode();

        // always check HTTP response code first
//        if (responseCode == HttpURLConnection.HTTP_OK) {
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();
            Map<String, List<String>> mapContent = httpConn.getHeaderFields();
            System.out.println(">>>>content");
            for(Map.Entry<String, List<String>> entry : mapContent.entrySet()){
                System.out.println("key:"+entry.getKey());
                for(int i = 0 ; i < entry.getValue().size();i++){
                    System.out.println(i+"):"+entry.getValue().get(i));
                }
            }
            System.out.println(">>>>end");

            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }

            fileName = "test.jpg";

            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn1.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn1.disconnect();
    }

    public static void main(String[] args) throws IOException{
        String url = "https://www.eiseverywhere.com/ereg/retrieve_upload.php?ODIwMDYyN180OTk5ODEyLmpwZw==";
        String dest = "E:\\var\\test";
        downloadFile(url, dest);
    }
}
