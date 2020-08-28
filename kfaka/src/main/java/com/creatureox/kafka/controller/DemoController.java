package com.creatureox.kafka.controller;

import com.creatureox.kafka.mq.producer.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/8/28
 * description:
 */
@RequestMapping("/kafka")
@RestController
public class DemoController {

    @Resource
    private Producer producer;

    @GetMapping("/publish")
    public void sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
    }

}
