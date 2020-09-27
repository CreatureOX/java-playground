package com.creatureox.memcached.service.impl;

import com.creatureox.memcached.service.MemcachedService;
import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.MemcachedClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author heyifan
 * version: 1.0
 * date: 2020/9/27
 * description:
 */
@Slf4j
@Service
public class MemcachedServiceImpl implements MemcachedService {

    @Resource
    private MemcachedClient memcachedClient;

    @Override
    public void set(String key, int expireSeconds, Object object) {
        memcachedClient.set(key, expireSeconds, object);
    }

    @Override
    public Object get(String key) {
        return memcachedClient.get(key);
    }
}
