package com.creatureox.memcached.common.config;

import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author heyifan
 * version: 1.0
 * date: 2020/9/27
 * description:
 */
@Slf4j
@Component
public class MemcachedConfig {

    @Value("${memcache.ip}")
    private String ip;

    @Value("${memcache.port}")
    private Integer port;

    @Bean
    public MemcachedClient getMemcachedClient(){
        MemcachedClient memcachedClient = null;
        try {
            memcachedClient = new MemcachedClient(new InetSocketAddress(ip, port));
        }catch (IOException e){
            log.error("init memcached client failed", e);
        }
        return memcachedClient;
    }

}
