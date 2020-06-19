package com.creatureox.drools.service.impl;

import com.creatureox.drools.dto.request.DemoReqDTO;
import com.creatureox.drools.service.RuleEngineService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.drools.core.base.RuleNameEndsWithAgendaFilter;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/6/6
 * description:
 */
@Slf4j
@Service
public class RuleEngineServiceImpl implements RuleEngineService {

    @Resource
    private KieSession kieSession;

    @Override
    public void test(String ruleName) {
        if (StringUtils.isNotBlank(ruleName)){
            kieSession.fireAllRules((match) -> match.getRule().getName().equals(ruleName));
            log.info("触发规则: {}", ruleName);
        }else {
           int count = kieSession.fireAllRules();
            log.info("触发所有规则");
        }
    }

    @Override
    public void paramCheck(DemoReqDTO reqDTO) {
        kieSession.insert(reqDTO);
        kieSession.fireAllRules(new RuleNameEndsWithAgendaFilter("paramCheck"));
    }

}
