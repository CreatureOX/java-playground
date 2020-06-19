package com.creatureox.drools;

import com.creatureox.drools.service.RuleEngineService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DroolsApplication.class)
public class DroolsApplicationTests {

    @Resource
    private RuleEngineService ruleEngineService;

    @Test
    public void testAllRules(){
        ruleEngineService.test(null);
    }

    @Test
    public void testTargetRule(){
        ruleEngineService.test("paramCheck");
    }
}
