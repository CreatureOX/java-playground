package com.creatureox.rocketmq;

import com.creatureox.rocketmq.service.RocketMqSendService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RocketMqProducerApplication.class)
@Slf4j
public class RocketMqProducerApplicationTests {

    @Resource
    private RocketMqSendService rocketMqSendService;

    @Test
    public void sendMessageTest() {
        rocketMqSendService.sendMessage("demo-topic", "This is a test message!");
    }

}
