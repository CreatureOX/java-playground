package com.creatureox.security.service.impl;

import com.creatureox.security.domain.entity.UserInfo;
import com.creatureox.security.domain.mapper.UserInfoMapper;
import com.creatureox.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/7/23
 * description:
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getByName(String name) {
        return userInfoMapper.selectByName(name);
    }

}
