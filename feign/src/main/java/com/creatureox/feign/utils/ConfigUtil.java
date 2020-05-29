package com.creatureox.feign.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author CreatureOX
 * date: 2020/5/28
 * description:
 */
@Slf4j
@Component
@ConfigurationProperties
public class ConfigUtil {

    public static List<String> specialHostList;

    @Value("#{'${special.host}'.split(',')}")
    public void setSpeicalHostList(List<String> hostList){
        specialHostList = hostList;
    }

}
