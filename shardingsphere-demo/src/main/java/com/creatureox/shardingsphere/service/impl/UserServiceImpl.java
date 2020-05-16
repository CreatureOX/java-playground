package com.creatureox.shardingsphere.service.impl;

import com.creatureox.shardingsphere.domain.entity.User;
import com.creatureox.shardingsphere.domain.mapper.UserMapper;
import com.creatureox.shardingsphere.dto.request.CreateUserDTO;
import com.creatureox.shardingsphere.dto.request.UpdateUserDTO;
import com.creatureox.shardingsphere.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/5/16
 * description:
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private Mapper mapper;

    @Override
    public User get(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insert(CreateUserDTO createUserDTO) {
        User user = mapper.map(createUserDTO, User.class);
        userMapper.insert(user);
    }

    @Override
    public void update(UpdateUserDTO updateUserDTO) {
        User user = mapper.map(updateUserDTO, User.class);
        userMapper.update(user);
    }
}
