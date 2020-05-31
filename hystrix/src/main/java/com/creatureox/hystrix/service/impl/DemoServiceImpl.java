package com.creatureox.hystrix.service.impl;

import com.creatureox.hystrix.service.DemoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author CreatureOX
 * date: 2020/5/30
 * description:
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Value("${hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds}")
    private Integer timeoutInMilliseconds;

    private static final Integer DELTA = 1000;

    @HystrixCommand(commandKey = "echo")
    @Override
    public String echo(String word) {
        sleepRandomMills(timeoutInMilliseconds + DELTA);
        return word;
    }

    @HystrixCommand(commandKey = "echoWithFallback", fallbackMethod = "defaultFallback")
    @Override
    public String echoWithFallback(String word) {
        sleepRandomMills(timeoutInMilliseconds + DELTA);
        return word;
    }

    private String defaultFallback(String word){
        return "fallback: " + word;
    }

    private void sleepRandomMills(int maxSleepMills){
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(maxSleepMills));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
