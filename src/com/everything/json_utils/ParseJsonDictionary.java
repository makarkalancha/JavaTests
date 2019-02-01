package com.everything.json_utils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//import java.util.Map;

/**
 * Created by mcalancea on 2016-02-09.
 */
public class ParseJsonDictionary {
    private static final Gson GSON = new Gson();
    private static final JsonParser JSON_PARSER = new JsonParser();

    public static void main(String[] args) throws IOException {
        //eo 3653
        //en 3644
        Multimap<String, String> dictionaryEn = getDictionary("dictionary_en.js");
        Multimap<String, String> dictionaryEo = getDictionary("dictionary_eo.js");

        System.out.println("dictionaryEn.size()" + dictionaryEn.size());
        System.out.println("dictionaryEo.size()" + dictionaryEo.size());

        Set<String> keyDictionaryEn = new HashSet<>(dictionaryEn.keySet());
        Set<String> keyDictionaryEo = new HashSet<>(dictionaryEo.keySet());
        Set<String> missingKeysInEo = new HashSet<>(keyDictionaryEn);
        missingKeysInEo.removeAll(keyDictionaryEo);
        Set<String> missingKeysInEn = new HashSet<>(keyDictionaryEo);
        missingKeysInEn.removeAll(keyDictionaryEn);

        System.out.println("missingKeysInEn: " + missingKeysInEn.size());
        System.out.println(missingKeysInEn);
        System.out.println("====================================");
        System.out.println("missingKeysInEo: " + missingKeysInEo.size());
        System.out.println(missingKeysInEo);
    }

    public static Multimap<String, String> getDictionary(String dictionaryFileName) throws IOException{
        Multimap<String, String> dictionary = ArrayListMultimap.create();

        String jsonString = readJsonDictionary(dictionaryFileName);

//        System.out.println(jsonString);

        JsonArray jsonArray = JSON_PARSER.parse(jsonString).getAsJsonArray();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        jsonArray.forEach(jsonElement -> {
            Map<String, String> myMap = GSON.fromJson(jsonElement, type);
            myMap.forEach((key, value) -> {
                        dictionary.put(key, value);
                    }
            );
        });
//        System.out.println("dictionary.size(): "+dictionary.size());

        for(String key : dictionary.keySet()) {
            Collection<String> values = dictionary.get(key);
            if(values.size() > 1) {
                System.out.println(key + "\t\"" + values + "\""+"\t"+values.size());
            }
        }
        return dictionary;
    }

    public static String readJsonDictionary(String dictionaryFileName) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dictionaryFileName));
        StringBuilder builder = new StringBuilder();
        String temp = null;
        while((temp = bufferedReader.readLine()) != null) {
            builder.append(temp.replaceAll(",","},{"));
        }
////        System.out.println(builder.length());
//        String tmp = "window.__dictionary = {  \"accountProfile\": \"Account Profile\",  \"accountProfile\": \"Your client account settings\",  \"basicFieldName\": \"Name\"};";
//        tmp = tmp.replaceAll(",", "},{");
//        builder.append(tmp);

        String stringToChange1 = "window.__dictionary = ";
        int indexStringToRemove = builder.indexOf(stringToChange1);
        builder.delete(indexStringToRemove, indexStringToRemove + stringToChange1.length());

        String stringToChange2 = ";";
        indexStringToRemove = builder.lastIndexOf(stringToChange2);
        builder.delete(indexStringToRemove, indexStringToRemove + stringToChange2.length());

        String stringToChange3 = "{";
        indexStringToRemove = builder.indexOf(stringToChange3);
        builder.replace(indexStringToRemove, indexStringToRemove + stringToChange3.length(), "[{");

        String stringToChange4 = "}";
        indexStringToRemove = builder.lastIndexOf(stringToChange4);
        builder.replace(indexStringToRemove, indexStringToRemove + stringToChange4.length(), "}]");

//        System.out.println(builder.length());
        return builder.toString();
    }
}
