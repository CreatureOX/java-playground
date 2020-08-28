package com.creatureox.kafka.mq.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/8/28
 * description:
 */
@Slf4j
@Component
public class Producer {

    public static final String DEMO_TOPIC = "DEMO_TOPIC";

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(Object message){
        log.info("send message: {}", message.toString());
        kafkaTemplate.send(DEMO_TOPIC, message.toString());
    }

}
