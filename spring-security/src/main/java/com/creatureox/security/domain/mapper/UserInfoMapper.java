package com.creatureox.security.domain.mapper;

import com.creatureox.security.domain.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author CreatureOX
 * date: 2020/7/23
 * description:
 */
@Mapper
public interface UserInfoMapper {

    /**
     * select by name
     *
     * @param name name
     * @return user info
     */
    UserInfo selectByName(String name);

}
