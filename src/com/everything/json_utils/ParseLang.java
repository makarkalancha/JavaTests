package com.everything.json_utils;

//import java.util.Map;

import com.everything.utils.fileUtils.FileList;
import com.everything.utils.fileUtils.FileUtils;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mcalancea on 2016-02-10.
 */
public class ParseLang {
    private static final Gson GSON = new Gson();
    private static final JsonParser JSON_PARSER = new JsonParser();

    public static void main(String[] args) throws IOException {
        findDuplicateKeys();
    }

    public static void readJsonDictionary(File filePath, Multimap<String, Translation> dictionary) throws IOException{
        String content = FileUtils.readFile(filePath);
        String jsonArrayString = convertJsonObjectStringToJsonArrayString(content);
//            System.out.println(jsonArrayString);
        JsonArray jsonArray = JSON_PARSER.parse(jsonArrayString).getAsJsonArray();
        Type type = new TypeToken<Map<String, Translation>>() {}.getType();
        jsonArray.forEach(jsonElement -> {
            Map<String, Translation> myMap = GSON.fromJson(jsonElement, type);
            myMap.forEach((key, value) -> {
                        dictionary.put(key, value);
                    }
            );
        });
    }

    public static void findDuplicateKeys() throws IOException{
        List<File> fileList = FileList.getFileList("z_lang");
        Multimap<String, Translation> dictionary = ArrayListMultimap.create();


        for(File file : fileList) {
//        readJsonDictionary(new File("z_lang\\cloner.json"), dictionary);
            readJsonDictionary(file, dictionary);
        }
        System.out.println("dictionary.size():"+dictionary.size());
        System.out.println("key\tvalues.size()\tsameTranslation.size()");
        for(String key : dictionary.keySet()) {
            Collection<Translation> values = dictionary.get(key);
            if(values.size() > 1) {
                Set<Translation> sameTranslation = new HashSet<>(values);
                System.out.println(key + "\t" + values.size() + "\t" + sameTranslation.size());
            }
        }
    }

    public static String convertJsonObjectStringToJsonArrayString(String json) {
        StringBuilder builder = new StringBuilder(json);
        String stringToChange1 = "{";
        int indexStringToRemove = builder.indexOf(stringToChange1);
        builder.replace(indexStringToRemove, indexStringToRemove + stringToChange1.length(), "[{");

        String stringToChange2 = "}";
        indexStringToRemove = builder.lastIndexOf(stringToChange2);
        builder.replace(indexStringToRemove, indexStringToRemove + stringToChange2.length(), "}]");

        String stringToChange3 = "},";
        String tmp = builder.toString().replaceAll("\\},","}},{");
        builder = new StringBuilder(tmp);

        return builder.toString();
    }

    private class Translation{
        private String en;
        private String fr;
        private String ja;

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getFr() {
            return fr;
        }

        public void setFr(String fr) {
            this.fr = fr;
        }

        public String getJa() {
            return ja;
        }

        public void setJa(String ja) {
            this.ja = ja;
        }

        @Override
        public String toString() {
            return "Translation{" +
                    "en='" + en + '\'' +
                    ", fr='" + fr + '\'' +
                    ", ja='" + ja + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Translation that = (Translation) o;

            if (en != null ? !en.equals(that.en) : that.en != null) {
                return false;
            }
            if (fr != null ? !fr.equals(that.fr) : that.fr != null) {
                return false;
            }
            return !(ja != null ? !ja.equals(that.ja) : that.ja != null);
        }

        @Override
        public int hashCode() {
            int result = en != null ? en.hashCode() : 0;
            result = 31 * result + (fr != null ? fr.hashCode() : 0);
            result = 31 * result + (ja != null ? ja.hashCode() : 0);
            return result;
        }
    }


}
