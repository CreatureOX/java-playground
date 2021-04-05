package com.creatureox.elasticsearch.dao;

import com.creatureox.elasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author CreatureOX
 * date: 2021/4/5
 * description:
 */
public interface UserDao extends ElasticsearchRepository<User, Long> {
}
