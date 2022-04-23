package com.creatureox.rocketmq.service;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2022/4/23
 * description:
 */
@Service
public class RocketMqSendService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void sendMessage(String topic, Object payload) {
        rocketMQTemplate.send("demo-topic", MessageBuilder.withPayload(payload).build());
    }

}
