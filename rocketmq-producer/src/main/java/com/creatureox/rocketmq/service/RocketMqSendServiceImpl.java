package com.creatureox.rocketmq.service;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/5/11
 * description:
 */
@Service
public class RocketMqSendServiceImpl implements RocketMqSendService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String topic, Object payload) {
        rocketMQTemplate.send("demo-topic", MessageBuilder.withPayload(payload).build());
    }

}
