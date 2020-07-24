package com.creatureox.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author CreatureOX
 * date: 2020/7/23
 * description:
 */
@Configuration
@EnableWebSecurity
public class InMemoryWebSecurityConfig {

    /**
     * in memory
     *
     * @return manager
     */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("admin").roles("ADMIN").build());
        manager.createUser(User.withUsername("guest").password("guest").roles("GUEST").build());
        return manager;
    }

}
