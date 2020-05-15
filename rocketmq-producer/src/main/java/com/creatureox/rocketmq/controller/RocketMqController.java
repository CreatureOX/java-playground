package com.creatureox.rocketmq.controller;

import com.creatureox.rocketmq.service.RocketMqSendService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/5/14
 * description:
 */
@RestController
@RequestMapping("/rocketmq")
@Slf4j
@Api(tags = "rocketmq demo")
public class RocketMqController {

    @Resource
    private RocketMqSendService rocketMqSendService;

    @PostMapping(value = "/send/message")
    public void sendMessage(@RequestParam("topic") String topic, @RequestParam("payload") String payload){
        rocketMqSendService.sendMessage(topic, payload);
    }

}
