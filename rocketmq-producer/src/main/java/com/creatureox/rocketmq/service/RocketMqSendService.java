package com.creatureox.rocketmq.service;

/**
 * @author CreatureOX
 * date: 2020/5/11
 * description:
 */
public interface RocketMqSendService {

    /**
     * send message
     * @param topic topic
     * @param payload payload
     */
    void sendMessage(String topic, Object payload);

}
