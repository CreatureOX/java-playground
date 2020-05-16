package com.creatureox.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = RocketMqConsumerApplication.class)
public class RocketMqConsumerApplicationTests {

    @Test
    public void contextLoads() {
        log.info("test");
    }

}
