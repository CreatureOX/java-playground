package com.creatureox.squirrel.service.impl;

import com.creatureox.squirrel.dto.request.UserActionRequestDTO;
import com.creatureox.squirrel.entity.GithubUser;
import com.creatureox.squirrel.service.ActionService;
import com.creatureox.squirrel.statemachine.context.GithubContext;
import com.creatureox.squirrel.statemachine.event.EventEnum;
import com.creatureox.squirrel.statemachine.factory.GithubStateMachineFactory;
import com.creatureox.squirrel.statemachine.service.GithubStateMachineService;
import com.creatureox.squirrel.statemachine.state.StateEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
@Slf4j
@Service
public class ActionServiceImpl implements ActionService {

    @Resource
    private GithubStateMachineFactory stateMachineFactory;

    @Override
    public GithubUser performAction(UserActionRequestDTO requestDTO) {
        GithubStateMachineService stateMachineService = stateMachineFactory.newGithubStateMachineService(StateEnum.INIT);
        GithubContext context = GithubContext.newInstance();
        GithubUser githubUser = new GithubUser();
        githubUser.setUserId(requestDTO.getUserId());
        if (1L == requestDTO.getUserId()) {
            githubUser.setName("demo1");
            githubUser.setState(StateEnum.INIT.getCode());
            githubUser.setStateDesc(StateEnum.INIT.getDesc());
        }else if (2L == requestDTO.getUserId()) {
            githubUser.setName("demo2");
            githubUser.setState(StateEnum.STARRED.getCode());
            githubUser.setStateDesc(StateEnum.STARRED.getDesc());
        }
        log.info("userId: {} old state: {} desc: {}", githubUser.getUserId(), githubUser.getState(), githubUser.getStateDesc());

        stateMachineService.fire(EventEnum.fromUserAction(requestDTO.getAction()), context);
        githubUser.setState(stateMachineService.getCurrentState().getCode());
        githubUser.setStateDesc(stateMachineService.getCurrentState().getDesc());
        log.info("userId: {} new state: {} desc: {}", githubUser.getUserId(), githubUser.getState(), githubUser.getStateDesc());
        return githubUser;
    }

}
