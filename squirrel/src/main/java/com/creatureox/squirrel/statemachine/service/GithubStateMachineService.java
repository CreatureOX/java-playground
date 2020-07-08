package com.creatureox.squirrel.statemachine.service;

import com.creatureox.squirrel.statemachine.context.GithubContext;
import com.creatureox.squirrel.statemachine.event.EventEnum;
import com.creatureox.squirrel.statemachine.state.StateEnum;
import lombok.extern.slf4j.Slf4j;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
@Slf4j
public class GithubStateMachineService extends AbstractStateMachine<GithubStateMachineService, StateEnum, EventEnum, GithubContext> {

}
