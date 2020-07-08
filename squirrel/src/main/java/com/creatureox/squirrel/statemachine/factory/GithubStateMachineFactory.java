package com.creatureox.squirrel.statemachine.factory;

import com.creatureox.squirrel.statemachine.context.GithubContext;
import com.creatureox.squirrel.statemachine.event.EventEnum;
import com.creatureox.squirrel.statemachine.service.GithubStateMachineService;
import com.creatureox.squirrel.statemachine.state.StateEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineConfiguration;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
@Component
public class GithubStateMachineFactory {

    @Resource
    private StateMachineBuilder<GithubStateMachineService, StateEnum, EventEnum, GithubContext> githubStateMachine;

    @Resource
    private ApplicationContext applicationContext;

    public GithubStateMachineService newGithubStateMachineService(StateEnum stateEnum){
        GithubStateMachineService service = githubStateMachine.newStateMachine(stateEnum, StateMachineConfiguration.create().enableDebugMode(true));
        applicationContext.getAutowireCapableBeanFactory().autowireBean(service);
        return service;
    }

}
