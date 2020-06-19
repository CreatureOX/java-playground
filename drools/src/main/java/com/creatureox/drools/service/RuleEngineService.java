package com.creatureox.drools.service;

import com.creatureox.drools.dto.request.DemoReqDTO;

/**
 * @author CreatureOX
 * date: 2020/6/6
 * description:
 */
public interface RuleEngineService {

    /**
     * rule test
     *
     * @param ruleName ruleName
     */
    void test(String ruleName);

    /**
     * param check
     *
     * @param reqDTO reqDTO
     */
    void paramCheck(DemoReqDTO reqDTO);

}
