package com.creatureox.security.config;

import com.creatureox.security.consts.Consts;
import com.creatureox.security.domain.entity.UserInfo;
import com.creatureox.security.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author CreatureOX
 * date: 2020/7/23
 * description:
 */
@Configuration
@EnableWebSecurity
public class RolePermissionWebSecurityConfig {

    @Resource
    private UserService userService;

    private static final String USERNAME_GUEST = "guest";
    private static final String USERNAME_ADMIN = "admin";
    private static final String USERNAME_NORMAL_1 = "normal1";
    private static final String USERNAME_NORMAL_2 = "normal2";
    private static final String USERNAME_NORMAL_3 = "normal3";
    private static final String USERNAME_NORMAL_4 = "normal4";


    /**
     * role permission
     *
     * @return manager
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
//            UserInfo userInfo = userService.getByName(username);
//            if (userInfo == null){
//                throw new UsernameNotFoundException("username not found");
//            }
            List<String> roles = Lists.newArrayList();
            List<String> permissions = Lists.newArrayList();
            if (USERNAME_GUEST.equals(username)){
                roles.add(Consts.RoleConst.GUEST);
                permissions.add(Consts.PermissionConst.GUEST);
            }else if (USERNAME_ADMIN.equals(username)){
                roles.add(Consts.RoleConst.ADMIN);
                permissions.add(Consts.PermissionConst.ADMIN);
            }else if (USERNAME_NORMAL_1.equals(username)){
                roles.add(Consts.RoleConst.NORMAL);
                permissions.add(Consts.PermissionConst.PERMISSION_1);
            }else if (USERNAME_NORMAL_2.equals(username)){
                roles.add(Consts.RoleConst.NORMAL);
                permissions.add(Consts.PermissionConst.PERMISSION_2);
            }else if (USERNAME_NORMAL_3.equals(username)){
                roles.add(Consts.RoleConst.NORMAL);
                permissions.add(Consts.PermissionConst.PERMISSION_3);
            }else if (USERNAME_NORMAL_4.equals(username)){
                roles.add(Consts.RoleConst.NORMAL);
                permissions.add(Consts.PermissionConst.PERMISSION_4);
            }

            String[] permissionArr = new String[roles.size() + permissions.size()];
            int permissionArrIndex = 0;
            for (String role: roles){
                permissionArr[permissionArrIndex] = "ROLE_" + role;
                permissionArrIndex++;
            }
            for (String permission: permissions){
                permissionArr[permissionArrIndex] = permission;
                permissionArrIndex++;
            }
            return User.withUsername(username).password(roles.get(0) + ":" + permissions.get(0))
                    .authorities(permissionArr)
                    .build();
        };
    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests().antMatchers("/guest/**").permitAll().and()
                        .authorizeRequests().antMatchers("/admin/**").hasRole("admin").and()
                        .authorizeRequests().antMatchers("/authenticated/**").authenticated().and()
                        .authorizeRequests().antMatchers("/permission1/**").hasAuthority("permission1").and()
                        .authorizeRequests().antMatchers("/permission2/**").hasAuthority("permission2").and()
                        .authorizeRequests().antMatchers("/permission3/**").hasAuthority("permission3").and()
                        .authorizeRequests().antMatchers("/permission4/**").hasAuthority("permission4").and().formLogin().and()
                        .authorizeRequests().anyRequest().permitAll();
            }
        };
    }

}
