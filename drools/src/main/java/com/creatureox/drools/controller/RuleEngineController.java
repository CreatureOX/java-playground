package com.creatureox.drools.controller;

import com.creatureox.drools.dto.request.DemoReqDTO;
import com.creatureox.drools.service.RuleEngineService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/6/6
 * description:
 */
@RequestMapping("/rule")
@RestController
public class RuleEngineController {

    @Resource
    private RuleEngineService ruleEngineService;

    @ResponseBody
    @GetMapping("/test")
    public void test(@RequestParam(value = "ruleName", required = false) String ruleName){
        ruleEngineService.test(ruleName);
    }

    @ResponseBody
    @PostMapping("/param-check")
    public void paramCheck(@RequestBody DemoReqDTO demoReqDTO){
        ruleEngineService.paramCheck(demoReqDTO);
    }

}
