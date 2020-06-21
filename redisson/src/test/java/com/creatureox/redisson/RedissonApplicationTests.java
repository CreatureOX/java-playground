package com.creatureox.redisson;

import com.creatureox.redisson.service.RateLimitService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RateIntervalUnit;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedissonApplication.class)
public class RedissonApplicationTests {

    @Resource
    private RateLimitService rateLimitService;

    @Test
    public void rateLimitTest() {
        log.info("{}", rateLimitService.isOverFrequency("token", 1, 5, RateIntervalUnit.SECONDS));
        log.info("{}", rateLimitService.isOverFrequency("token", 1, 5, RateIntervalUnit.SECONDS));
    }

}
