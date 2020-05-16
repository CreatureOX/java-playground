package com.creatureox.shardingsphere.domain.mapper;

import com.creatureox.shardingsphere.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author CreatureOX
 * date: 2020/5/16
 * description:
 */
@Mapper
public interface UserMapper {

    /**
     * insert
     * @param user user
     * @return
     */
    int insert(User user);

    /**
     * update
     * @param user user
     * @return
     */
    void update(User user);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return
     */
    User selectByPrimaryKey(Long id);

}
