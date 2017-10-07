package com.everything.json_utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang.StringUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * User: Makar Kalancha
 * Date: 31/10/13
 * Time: 11:23 AM
 */
public class GsonTest {
    private Gson _gson = new Gson();
    private Path file_p = Paths.get("D:\\Tasks\\!_archive\\011_573_rsna_speaker\\json_test.js");

    public static void main(String [] args) {
//        com.everything.json_utils.GsonTest g = new com.everything.json_utils.GsonTest();
//        String json = "";
//        BufferedReader br = null;
//        try{
//            br = new BufferedReader(new FileReader(g.file_p.toFile()));
//
//
//            String tmp = "";
//            while( (tmp = br.readLine()) != null){
//                System.out.println(tmp);
//                json += tmp;
//            }
//            System.out.println(g.file_p.toString());
//            System.out.println(tmp);
//            System.out.println(json);
//        }catch(FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        com.everything.json_utils.GsonTest.SomeData someData = g._gson.fromJson(json, com.everything.json_utils.GsonTest.SomeData.class);
//        System.out.println(someData);
//

//        String transform = "{\"image_resize\":{\"width\":170}}";
//        System.out.println(transform);
//
////        Gson gson = new Gson();
//        JsonParser jsonParser = new JsonParser();
//        JsonElement jsonElement = jsonParser.parse(transform);
////        JsonObject jsonObject  = (JsonObject) jsonParser.parse(transform);
//        JsonObject jsonObject = jsonElement.getAsJsonObject();
//        JsonObject image_resize = jsonObject.getAsJsonObject("image_resize");
//        int width = image_resize.getAsJsonPrimitive("width").getAsInt();
//
//        System.out.println(image_resize);
//        System.out.println(width);
////        gson.fromJson(transform, String.class);


//        String resultRow =
//                removeColumn(row1, valueId);
////        removeColumn(row2, valueId);
//        System.out.println(">>>result:>>" + resultRow);

//        for(String row : row3){
//            String resultForRow = removeColumn(row, valueId);
//            System.out.println(resultForRow);
//        }

        JsonParser parser = new JsonParser();
        JsonElement o1 = parser.parse("{a : {a : 2}, b : 2}");
        JsonElement o2 = parser.parse("{b : 2, a : {a : 2}}");
        System.out.println((o1.equals(o2)));

        String json = "{a-0.1 : 2 , b : \"2\" , c-2.3 : [ {isNew : true, value : 2},{isNew : false, value : 12}] }";
        Gson gson =
                new Gson();
//                new GsonBuilder()
//                .setFieldNamingStrategy(new FieldNamingStrategy() {
//                    public String translateName(final Field field) {
//                        final S1erializedName annotation = field.getAnnotation(S1erializedName.class);
//                        return ((null != annotation) && null != annotation.value()) ? annotation.value() : field.getName();
//                    }
//                }).create();
        JsonTestClass tc = gson.fromJson(json, JsonTestClass.class);
        System.out.println(tc);

//        Gson gson = new Gson();
        //
//        TestClass wb = gson.fromJson(row1, TestClass.class);
//        System.out.println(wb);
//        wb.removeFiltersByColumnName(valueId);
//        String newJson = gson.toJson(wb);
//        System.out.println(">>>json:\n" + newJson);
    }

    public static String removeColumn(String row, String columnName){
        String CAL_STAT_COL_PREFIX = "someOtherColumn";
        String COLUMNS_SEPARATOR = "~";

        StringBuilder result = new StringBuilder();
        if(row.contains(columnName)) {
            if (row.startsWith("{")) {
//                result = parseHugeJsonManually(row, columnName);
                result = parseHugeJsonWithGson(row, columnName);
            } else if (row.contains(COLUMNS_SEPARATOR)) {
                List<String> items = new ArrayList<>(Arrays.asList(row.split(COLUMNS_SEPARATOR)));
//                System.out.println(items);
                items.removeIf(p -> p.equalsIgnoreCase(columnName));
//                System.out.println(items);
                result.append(StringUtils.join(items, COLUMNS_SEPARATOR));
//                StringJoiner joiner = new StringJoiner(COLUMNS_SEPARATOR);
//                joiner.add(items);
            }
        } else {
            result.append(row);
        }
        return result.toString();
    }

    public static StringBuilder parseHugeJsonWithGson(String row, String columnName) {
////version gson 2.2 at least
//        StringBuilder result = new StringBuilder();
//        Gson gson = new Gson();
//        TestClass wb = gson.fromJson(row, TestClass.class);
////        System.out.println(wb);
//        wb.removeFiltersByColumnName(columnName);
//        StringBuilder newJson = new StringBuilder(gson.toJson(wb));
////        System.out.println(">>>json:\n" + newJson);
//        return newJson;

        StringBuilder result = new StringBuilder();
        Gson gson =
                new Gson();
//                new GsonBuilder()
//                .setFieldNamingStrategy(new FieldNamingStrategy() {
//                    public String translateName(final Field field) {
//                        final S1erializedName annotation = field.getAnnotation(S1erializedName.class);
//                        return ((null != annotation) && null != annotation.value()) ? annotation.value() : field.getName();
//                    }
//                }).create();
        TestClass wb = gson.fromJson(row, TestClass.class);
//        System.out.println(wb);
        wb.removeFiltersByColumnName(columnName);
        StringBuilder newJson = new StringBuilder(gson.toJson(wb));
//        System.out.println(">>>json:\n" + newJson);
        return newJson;
    }

    public static StringBuilder parseHugeJsonManually(String row, String columnName) {
        StringBuilder result = new StringBuilder();
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(row).getAsJsonObject();
        int i = 0;
        int j = 0;
        int k = 0;
        JsonObject resultJson = new JsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
//                    System.out.println(++i);
            ++i;
            JsonElement wbJsonElement = entry.getValue();
            //without string i:33; j:46; k:85
            //with string i:33; j:2; k:5
            if (wbJsonElement.toString().contains(columnName) && wbJsonElement.isJsonArray()) {
                JsonArray array = wbJsonElement.getAsJsonArray();
                JsonArray newArrayCodeHolderElement = new JsonArray();
                for (JsonElement codeHolderElement : array) {
//                                System.out.println(++j);
                    ++j;
                    //without string i:33; j:2; k:5
                    //with string i:33; j:2; k:3
//                            System.out.println(">>>codeHolderElement:" + codeHolderElement);
                    if (codeHolderElement.toString().contains(columnName) && codeHolderElement.isJsonObject()) {
                        JsonObject object = new JsonObject();
                        for (Map.Entry<String, JsonElement> codeHolderElementEntry : codeHolderElement.getAsJsonObject().entrySet()) {
//                                    System.out.println(">>>:"+codeHolderElementEntry.getKey()+">"+codeHolderElementEntry.getValue());
                            if (codeHolderElementEntry.getKey().equals("filters")) {
                                JsonArray newArrayFilter = new JsonArray();
                                for (JsonElement filter : codeHolderElementEntry.getValue().getAsJsonArray()) {
//                                      System.out.println(++k);
                                    ++k;
                                    if (filter.isJsonObject() && filter.getAsJsonObject().get("columnId").getAsString().equals(columnName)) {
                                        System.out.println(">>>110:" + filter);
                                    } else {
                                        newArrayFilter.add(filter);
                                    }
                                }
                                object.add(codeHolderElementEntry.getKey(), newArrayFilter);
//                                        System.out.println(">>>second if newCodeHolderArray:" + entry.getKey() + ">" + newArrayFilter);
                            } else {
                                object.add(codeHolderElementEntry.getKey(), codeHolderElementEntry.getValue());
                            }
                        }
                        newArrayCodeHolderElement.add(object);
//                                System.out.println(">>>second if codeHolderElement:" + entry.getKey() + ">" + codeHolderElement);
                    } else {
//                                System.out.println(">>>second else codeHolderElement:" + entry.getKey()+">"+codeHolderElement);
                        newArrayCodeHolderElement.add(codeHolderElement);
                    }
                }
//                        System.out.println(">>>after loop:" + entry.getKey()+">"+newArrayCodeHolderElement);
                resultJson.add(entry.getKey(), newArrayCodeHolderElement);
            } else {
//                        System.out.println(">>>first else:" + entry.getKey() + ">" + entry.getValue());
                resultJson.add(entry.getKey(), entry.getValue());
            }
        }
        result.append(resultJson);
        System.out.println(">>>i:" + i + "; j:" + j + "; k:" + k);

//                String imgurl = jsonObject.get("filters").getAsString();
//                System.out.println(jsonObject);
        return result;
    }


    public static class SomeData{
        private String PARENT;
        private String AM_ID;
        private String GUID;
        private String EM_ID;
        private String ACTIVE;

        @Override
        public String toString() {
            return "PARENT: "+PARENT+", AM_ID: "+AM_ID+", GUID: "+GUID+", EM_ID: "+EM_ID+", ACTIVE: "+ACTIVE+";";
        }

        public void setAM_ID(String am_id){
            if(am_id.equals("1")){
                this.AM_ID = "2";
            }
        }
    }
}
