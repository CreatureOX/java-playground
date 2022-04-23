package com.creatureox.rocketmq.controller;

import com.creatureox.rocketmq.service.RocketMqSendService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/rocketmq")
@RestController
public class RocketMqController {

    @Resource
    private RocketMqSendService rocketMqSendService;

    @PostMapping(value = "/send/message")
    public void sendMessage(@RequestParam("topic") String topic, @RequestParam("payload") String payload){
        rocketMqSendService.sendMessage(topic, payload);
    }

}
