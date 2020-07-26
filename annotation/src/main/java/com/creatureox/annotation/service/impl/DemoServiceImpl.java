package com.creatureox.annotation.service.impl;

import com.creatureox.annotation.dto.request.TestReqDTO;
import com.creatureox.annotation.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author CreatureOX
 * date: 2020/7/26
 * description:
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String echo(String test) {
        return test;
    }

    @Override
    public void test(TestReqDTO reqDTO) {

    }

}
