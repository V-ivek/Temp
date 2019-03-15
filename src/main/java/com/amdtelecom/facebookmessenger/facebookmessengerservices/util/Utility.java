package com.amdtelecom.facebookmessenger.facebookmessengerservices.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.UUID;

public class Utility {
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }

    public static String convertBeanToJson(Object object) {
        String value = null;
        try {
            ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
            value = mapper.writeValueAsString(object);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static Map<String, String> convertJsonToMap(String jsonString, String key) {
        Map<String, String> metadata = null;
        JSONObject jsonObject = new JSONObject(jsonString);
        if(!jsonObject.isEmpty()) {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            metadata = gson.fromJson(jsonObject.get(key).toString(), type);
        }
        return metadata;
    }
}
