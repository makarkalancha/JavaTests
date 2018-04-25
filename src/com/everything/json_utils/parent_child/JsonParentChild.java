package com.everything.json_utils.parent_child;

import com.everything.json_utils.parent_child.test002.Item2;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

//import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by mcalancea
 * Date: 24 Apr 2018
 * Time: 12:05
 */
public class JsonParentChild {
    private static final String JSON_PATH = "/JsonParentChild.json";
    private static final String NO_NAME_JSON_PATH = "/JsonParentChild_noName.json";
    private static final String NO_USER2_JSON_PATH = "/JsonParentChild_noUser2.json";

    public static void main(String[] args) throws Exception {
//        String json1 = convertPrettyJsonStringToString(JSON_PATH);
//        System.out.println(json1);
//        Item1 item1 = new ObjectMapper().readValue(json1, Item1.class);
//        System.out.println(item1);

        System.out.println("====================================================");
        String json2_1 = convertPrettyJsonStringToString(JSON_PATH);
        System.out.println(json2_1);
        Item2 item2_1 = new ObjectMapper().readValue(json2_1, Item2.class);
        System.out.println(item2_1);
        System.out.println("====================================================");
        String json2_2 = convertPrettyJsonStringToString(NO_NAME_JSON_PATH);
        System.out.println(json2_2);
        Item2 item2_2 = new ObjectMapper().readValue(json2_2, Item2.class);
        System.out.println(item2_2);
        System.out.println("====================================================");
        String json2_3 = convertPrettyJsonStringToString(NO_USER2_JSON_PATH);
        System.out.println(json2_3);
        Item2 item2_3 = new ObjectMapper().readValue(json2_3, Item2.class);
        System.out.println(item2_3);
    }

    private static String convertPrettyJsonStringToString(String path) throws IOException {
        String json = FileUtils.readFileToString(new File(JsonParentChild.class.getResource(path).getFile()));
        ObjectMapper objectMapper = new ObjectMapper();
        Object expectedObj = objectMapper.readValue(json, Object.class);
        return objectMapper.writeValueAsString(expectedObj);
    }
}
