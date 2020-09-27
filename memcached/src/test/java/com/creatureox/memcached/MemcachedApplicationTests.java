package com.creatureox.memcached;

import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcachedApplicationTests {

    @Resource
    private MemcachedClient memcachedClient;

    @Test
    public void testSetGet() {
        memcachedClient.set("testkey", 1000, "abcde");
        log.info("get: {}", memcachedClient.get("testkey").toString());
    }

}
