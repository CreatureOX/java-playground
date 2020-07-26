package com.creatureox.annotation.controller;

import com.creatureox.annotation.aop.annotation.ByteLength;
import com.creatureox.annotation.aop.annotation.OperationLog;
import com.creatureox.annotation.dto.request.TestReqDTO;
import com.creatureox.annotation.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/7/26
 * description:
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Resource
    private DemoService demoService;

    @OperationLog
    @GetMapping("/echo")
    public String echo(@RequestParam("word") @ByteLength(max = 5) String word){
        return demoService.echo(word);
    }

    @OperationLog
    @PostMapping("/test")
    public void test(@RequestBody @Validated TestReqDTO reqDTO){
        demoService.test(reqDTO);
    }

}
