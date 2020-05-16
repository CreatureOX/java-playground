package com.creatureox.shardingsphere;

import com.creatureox.shardingsphere.domain.entity.User;
import com.creatureox.shardingsphere.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingSphereDemoApplication.class)
public class ShardingSphereDemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void createTest() {
        User user = new User();
        user.setId(16L);
        user.setName("test create");
        userMapper.insert(user);
    }

    @Test
    public void updateTest() {
        User user = new User();
        user.setId(16L);
        user.setName("test update");
        userMapper.update(user);
    }

    @Test
    public void getTest() {
        User user = userMapper.selectByPrimaryKey(16L);
        log.info("user: {}", user.toString());
    }

}
