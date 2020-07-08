package com.creatureox.squirrel.statemachine;

import com.creatureox.squirrel.SquirrelApplication;
import com.creatureox.squirrel.dto.request.UserActionRequestDTO;
import com.creatureox.squirrel.service.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SquirrelApplication.class)
public class SquirrelApplicationTests {

    @Resource
    private ActionService actionService;

    @Test
    public void userStar() {
        UserActionRequestDTO requestDTO = new UserActionRequestDTO();
        requestDTO.setUserId(1L);
        requestDTO.setAction("STAR");
        actionService.performAction(requestDTO);
    }

}
