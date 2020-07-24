package com.creatureox.security.config;

import com.creatureox.security.domain.entity.UserInfo;
import com.creatureox.security.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/7/23
 * description:
 */
@Configuration
@EnableWebSecurity
public class DbWebSecurityConfig {

    @Resource
    private UserService userService;

    /**
     * in db
     *
     * @return manager
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            UserInfo userInfo = userService.getByName(username);
            if (userInfo == null){
                throw new UsernameNotFoundException("username not found");
            }
            return User.withUsername(username).password("dbAdmin").roles("NORMAL").build();
        };
    }

}
