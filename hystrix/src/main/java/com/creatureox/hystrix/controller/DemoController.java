package com.creatureox.hystrix.controller;

import com.creatureox.hystrix.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/5/30
 * description:
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping(value = "/echo")
    public String echo(@RequestParam("word") String word){
        return demoService.echo(word);
    }

    @GetMapping(value = "/echo-with-fallback")
    public String echoWithFallback(@RequestParam("word") String word){
        return demoService.echoWithFallback(word);
    }

}
