package org.uni;

import org.uni.model.ArrayMap;

import java.util.Arrays;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        ArrayMap<String, String> map = new ArrayMap<>();
        map.put("1", "12");
        map.put("2", "15");
        map.put("3", "15");
        map.put("4", "15");
        map.put("5", "15");
        map.put("6", "15");
        map.put("7", "15");
        map.put("8", "15");
        map.put("9", "15");
        map.put("10", "15");

        String mapGetValue = map.get("10");

        System.out.println(mapGetValue);
        System.out.println(map.size());
    }
}