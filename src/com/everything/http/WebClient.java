package com.everything.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mcalancea
 * Date: 30 Nov 2017
 * Time: 18:05
 */
public class WebClient {
    public static void main(String[] args){
        StringBuilder urlSB = new StringBuilder();
        http://fixer.io/

//https://stackoverflow.com/questions/1359689/how-to-send-http-request-in-java
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlSB.toString());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

        }catch (IOException e)/*{*/
            e.printStackTrace();
        }
    }
}
