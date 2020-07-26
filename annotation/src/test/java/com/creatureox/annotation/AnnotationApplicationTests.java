package com.creatureox.annotation;

import com.creatureox.annotation.controller.DemoController;
import com.creatureox.annotation.dto.request.TestReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AnnotationApplication.class)
public class AnnotationApplicationTests {

    @Resource
    private DemoController demoController;

    @Test
    public void operationLogTest(){
        demoController.echo("word");

        TestReqDTO reqDTO = new TestReqDTO();
        reqDTO.setTest("sd");
        demoController.test(reqDTO);
    }

    @Test
    public void ByteLengthTest() {
        TestReqDTO reqDTO = new TestReqDTO();
        reqDTO.setTest("sdsdsadsadsadsad");
        demoController.test(reqDTO);
    }

}
