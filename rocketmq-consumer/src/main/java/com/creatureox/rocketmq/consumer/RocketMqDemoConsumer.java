package com.creatureox.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author CreatureOX
 * date: 2020/5/16
 * description:
 */
@Slf4j
@Component
@ConfigurationProperties
public class RocketMqDemoConsumer {

    @Value("${rocketmq.name-server}")
    private String namessrvAddr;

    @Value("${rocketmq.bind.topic}")
    private String bindTopic;

    @Value("${rocketmq.consumer.group}")
    private String consumerGroup;

    @PostConstruct
    public void defaultMQPushConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(namessrvAddr);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(bindTopic, "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt: list){
                    log.info("messageExt: {}", messageExt);
                    try {
                        String messageBody = new String(messageExt.getBody(), "utf-8");
                        log.info("consume response: {}, msgBody: {}", messageExt.getMsgId(), messageBody);
                    }catch (UnsupportedEncodingException e){
                        e.printStackTrace();
                    }
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }

}
