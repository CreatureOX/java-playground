package com.creatureox.prometheus.controller;

import com.creatureox.prometheus.monitor.PrometheusCustomMonitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author CreatureOX
 * date: 2020/7/18
 * description:
 */
@RestController
@RequestMapping("/prometheus")
@Slf4j
public class PrometheusCustomController {

    @Resource
    private PrometheusCustomMonitor monitor;

    @GetMapping(value = "/order")
    public String order(@RequestParam String flag) throws Exception{
        monitor.getOrderCount().increment();
        if ("-1".equals(flag)){
            throw new Exception("Error!");
        }
        Random random = new Random();
        int amount = random.nextInt(100);
        monitor.getAmountSum().record(amount);
        return "order ok, amount: " + amount;
    }

}
