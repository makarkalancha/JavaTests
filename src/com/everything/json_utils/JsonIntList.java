package com.everything.json_utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mcalancea
 * Date: 15 Dec 2017
 * Time: 14:13
 */
public class JsonIntList {
    public static void main(String[] args) {
        Gson gson = new Gson();

        List<Integer> integersToJson = Arrays.asList(1, 3, 5);
        String toJson = gson.toJson(integersToJson);
        System.out.println(toJson);

        String fromJson = "[2,4,6]";
        List<Integer> integersFromJson = gson.fromJson(fromJson, new TypeToken<ArrayList<Integer>>() {}.getType());
        System.out.println(integersFromJson);
    }
}
