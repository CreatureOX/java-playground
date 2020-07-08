package com.creatureox.squirrel.controller;

import com.creatureox.squirrel.dto.request.UserActionRequestDTO;
import com.creatureox.squirrel.entity.GithubUser;
import com.creatureox.squirrel.service.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Resource
    private ActionService actionService;

    @PostMapping("/perform/action")
    public GithubUser performSomeAction(@RequestBody UserActionRequestDTO requestDTO){
        return actionService.performAction(requestDTO);
    }



}
