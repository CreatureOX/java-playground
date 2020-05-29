package com.creatureox.feign.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * @author CreatureOX
 * date: 2020/5/29
 * description:
 */
public class HttpUtil {

    private HttpUtil(){

    }

    public static String mapToGetParams(Map<String, Object> map){
        if (map == null){
            return "";
        }
        return "";
    }

    public static String getHost(String url){
        try {
            return new URL(url).getHost();
        }catch (MalformedURLException e){
            return "";
        }
    }

}
