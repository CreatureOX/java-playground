package com.creatureox.memcached.service;

/**
 * @author heyifan
 * version: 1.0
 * date: 2020/9/27
 * description:
 */
public interface MemcachedService {

    /**
     * set
     * @param key key
     * @param expireSeconds expire seconds
     * @param object object
     */
    void set(String key, int expireSeconds, Object object);

    /**
     * get
     * @param key key
     * @return Object
     */
    Object get(String key);

}
