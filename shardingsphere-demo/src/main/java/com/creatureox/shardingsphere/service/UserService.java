package com.creatureox.shardingsphere.service;

import com.creatureox.shardingsphere.domain.entity.User;
import com.creatureox.shardingsphere.dto.request.CreateUserDTO;
import com.creatureox.shardingsphere.dto.request.UpdateUserDTO;

/**
 * @author CreatureOX
 * date: 2020/5/16
 * description:
 */
public interface UserService {

    /**
     * get
     * @param id id
     * @return
     */
    User get(Long id);

    /**
     * insert
     * @param createUserDTO createUserDTO
     */
    void insert(CreateUserDTO createUserDTO);

    /**
     * update
     * @param updateUserDTO updateUserDTO
     */
    void update(UpdateUserDTO updateUserDTO);

}
