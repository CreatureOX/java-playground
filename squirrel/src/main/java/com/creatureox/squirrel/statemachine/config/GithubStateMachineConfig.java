package com.creatureox.squirrel.statemachine.config;

import com.creatureox.squirrel.statemachine.context.GithubContext;
import com.creatureox.squirrel.statemachine.event.EventEnum;
import com.creatureox.squirrel.statemachine.service.GithubStateMachineService;
import com.creatureox.squirrel.statemachine.state.StateEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
@Configuration
public class GithubStateMachineConfig {

    @Bean(name = "githubStateMachine")
    public StateMachineBuilder<GithubStateMachineService, StateEnum, EventEnum, GithubContext> githubStateMachine(){
        StateMachineBuilder<GithubStateMachineService, StateEnum, EventEnum, GithubContext> builder = StateMachineBuilderFactory
                .create(GithubStateMachineService.class, StateEnum.class, EventEnum.class, GithubContext.class);

        builder.externalTransition()
                .from(StateEnum.INIT)
                .to(StateEnum.STARRED)
                .on(EventEnum.STAR);

        builder.externalTransition()
                .from(StateEnum.INIT)
                .to(StateEnum.FORKED)
                .on(EventEnum.FORK);

        builder.externalTransition()
                .from(StateEnum.INIT)
                .to(StateEnum.WATCHED)
                .on(EventEnum.WATCH);

        builder.externalTransition()
                .from(StateEnum.STARRED)
                .to(StateEnum.INIT)
                .on(EventEnum.UNSTAR);

        builder.externalTransition()
                .from(StateEnum.FORKED)
                .to(StateEnum.INIT)
                .on(EventEnum.UNFORK);

        builder.externalTransition()
                .from(StateEnum.WATCHED)
                .to(StateEnum.INIT)
                .on(EventEnum.UNWATCH);

        builder.externalTransition()
                .from(StateEnum.INIT)
                .to(StateEnum.LOGOUT)
                .on(EventEnum.LEAVE);

        builder.externalTransition()
                .from(StateEnum.STARRED)
                .to(StateEnum.LOGOUT)
                .on(EventEnum.LEAVE);

        builder.externalTransition()
                .from(StateEnum.FORKED)
                .to(StateEnum.LOGOUT)
                .on(EventEnum.LEAVE);

        builder.externalTransition()
                .from(StateEnum.WATCHED)
                .to(StateEnum.LOGOUT)
                .on(EventEnum.LEAVE);

        return builder;
    }

}
