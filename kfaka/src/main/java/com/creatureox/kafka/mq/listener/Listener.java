package com.creatureox.kafka.mq.listener;

import com.creatureox.kafka.mq.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author CreatureOX
 * date: 2020/8/28
 * description:
 */
@Slf4j
@Component
public class Listener {

    @KafkaListener(topics = Producer.DEMO_TOPIC)
    public void consumeMessage(Object message){
        log.info("consume message: {}", message.toString());
    }

}
