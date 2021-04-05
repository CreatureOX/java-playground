package com.creatureox.elasticsearch.service;

import com.creatureox.elasticsearch.dao.UserDao;
import com.creatureox.elasticsearch.entity.User;
import com.google.common.collect.Lists;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * @author CreatureOX
 * date: 2021/4/5
 * description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> search(String searchContent) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchContent);
        Iterator<User> searchResult = userDao.search(builder).iterator();
        List<User> users = Lists.newArrayList();
        while (searchResult.hasNext()){
            users.add(searchResult.next());
        }
        return users;
    }

    @Override
    public List<User> search(String searchContent, Integer pageNum, Integer pageSize) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchContent);
        PageRequest pageRequest = new PageRequest(pageNum, pageSize);
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(builder)
                .withPageable(pageRequest)
                .build();
        Page<User> userPage = userDao.search(searchQuery);
        return userPage.getContent();
    }

}
