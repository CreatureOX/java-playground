package com.creatureox.elasticsearch.service;

import com.creatureox.elasticsearch.entity.User;

import java.util.List;

/**
 * @author CreatureOX
 * date: 2021/4/5
 * description:
 */
public interface UserService {

    /**
     * elasticsearch search
     *
     * @param searchContent search content
     * @return search result
     */
    List<User> search(String searchContent);

    /**
     * elasticsearch search
     *
     * @param searchContent search content
     * @param pageNum page number
     * @param pageSize page size
     * @return search result
     */
    List<User> search(String searchContent, Integer pageNum, Integer pageSize);

}
