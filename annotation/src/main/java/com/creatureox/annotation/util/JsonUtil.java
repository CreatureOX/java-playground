package com.creatureox.annotation.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author CreatureOX
 * date: 2020/7/26
 * description:
 */
@Slf4j
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtil() {
    }

    private static String writeValue(Object object){
        if (object == null){
            return null;
        }else if (object instanceof String){
            return (String) object;
        }else {
            try {
                return OBJECT_MAPPER.writeValueAsString(object);
            }catch (JsonProcessingException e){
                log.error("writeJsonValue error, ", e);
                return null;
            }
        }
    }

    private static <T> T readValue(String json, Class <T> t) {
        if (json == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(json, t);
            } catch (Exception var3) {
                log.error("readJsonValue error, ", var3);
                return null;
            }
        }
    }

    private static <T> T readValue(String json, TypeReference<T> t) {
        if (json == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(json, t);
            } catch (Exception var3) {
                log.error("readJsonValue error, ", var3);
                return null;
            }
        }
    }

    public static String toString(Object object) {
        return writeValue(object);
    }

    public static <T> T toBean(String json, Class <T> t) {
        return readValue(json, t);
    }

}
