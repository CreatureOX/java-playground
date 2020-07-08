package com.creatureox.squirrel.controller;

import com.creatureox.squirrel.statemachine.factory.GithubStateMachineFactory;
import com.creatureox.squirrel.statemachine.service.GithubStateMachineService;
import com.creatureox.squirrel.statemachine.state.StateEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.squirrelframework.foundation.component.SquirrelProvider;
import org.squirrelframework.foundation.fsm.DotVisitor;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
@RestController
@RequestMapping("/export")
@Slf4j
public class ExportController {

    @Resource
    private GithubStateMachineFactory githubStateMachineFactory;

    @GetMapping("/github-machine")
    public void githubMachineExport(){
        GithubStateMachineService stateMachineService = githubStateMachineFactory.newGithubStateMachineService(StateEnum.INIT);

        DotVisitor visitor = SquirrelProvider.getInstance().newInstance(DotVisitor.class);
        stateMachineService.accept(visitor);
        visitor.convertDotFile("GithubStateMachineService");
    }

}
