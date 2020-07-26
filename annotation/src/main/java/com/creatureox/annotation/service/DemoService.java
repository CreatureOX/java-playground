package com.creatureox.annotation.service;

import com.creatureox.annotation.dto.request.TestReqDTO;

/**
 * @author CreatureOX
 * date: 2020/7/26
 * description:
 */
public interface DemoService {

    /**
     * echo
     *
     * @param test test
     * @return test
     */
    String echo(String test);

    /**
     * test
     *
     * @param reqDTO reqDTO
     */
    void test(TestReqDTO reqDTO);

}
