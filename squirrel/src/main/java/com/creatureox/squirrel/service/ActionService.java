package com.creatureox.squirrel.service;

import com.creatureox.squirrel.dto.request.UserActionRequestDTO;
import com.creatureox.squirrel.entity.GithubUser;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
public interface ActionService {

    /**
     * user perform action
     *
     * @param requestDTO requestDTO
     * @return user
     */
    GithubUser performAction(UserActionRequestDTO requestDTO);

}
