package com.zhang.security.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    public static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    public static Map<String, Boolean> JsonToMap(String jsonString) {
        //json字符串转为Map对象
        Map<String, Boolean> map = null;
        try {
            map = mapper.readValue(jsonString, Map.class);
        } catch (JsonProcessingException e) {
            System.out.println("Failed : JsonToMap");
        }
        return map;
    }

    public static String MapToJson(Map map) {
        try {
            return mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            System.out.println("Failed : MapToJson");
        }
        return null;
    }

    public static String listToJsonArray(List list) {
        ArrayList<String> objArray = new ArrayList<>();
        String jsonArray = "";
        try {
            //遍历列表，将每个对象转换为jsonObj
            for (Object o : list) {
                String jsonObj = mapper.writeValueAsString(o);
                objArray.add(jsonObj);
            }
            //将所有jsonObj数组，转换为jsonArray
            jsonArray = mapper.writeValueAsString(objArray);
        } catch (JsonProcessingException e) {
            System.out.println("转换失败！");
        }
        return jsonArray;
    }

    public static String objToJsonObj(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            System.out.println("转换失败！");
        }
        return null;
    }
}
