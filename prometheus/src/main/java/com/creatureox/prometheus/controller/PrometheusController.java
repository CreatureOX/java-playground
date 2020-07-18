package com.creatureox.prometheus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CreatureOX
 * date: 2020/7/18
 * description:
 */
@RestController
@RequestMapping("/prometheus")
@Slf4j
public class PrometheusController {

    @GetMapping(value = "/demo/get")
    public String get(){
        return "DemoGet";
    }

    @PostMapping(value = "/demo/post")
    public String post(){
        return "DemoPost";
    }
}
