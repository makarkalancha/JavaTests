package com.everything.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 18/06/14
 * Time: 11:27 AM
 */
public class UrlReader {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://master.prod1.shserv.com/lifecycle_mock.php");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            for(int i=0;(line = br.readLine()) != null;i++){
                System.out.println(i+":"+line);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
