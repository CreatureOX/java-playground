package com.creatureox.security.service;

import com.creatureox.security.domain.entity.UserInfo;

/**
 * @author CreatureOX
 * date: 2020/7/23
 * description:
 */
public interface UserService {

    /**
     * get by name
     *
     * @param name name
     * @return response
     */
    UserInfo getByName(String name);

}
