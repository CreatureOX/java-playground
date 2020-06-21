package com.creatureox.redisson.controller;

import com.creatureox.redisson.dto.request.RateLimitConfigDTO;
import com.creatureox.redisson.service.RateLimitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/6/21
 * description:
 */
@Slf4j
@RestController
@RequestMapping("/redisson")
public class RedissonController {

    @Resource
    private RateLimitService rateLimitService;

    @PostMapping("/rate-limit/test")
    public boolean testRateLimit(@RequestBody RateLimitConfigDTO rateLimitConfigDTO){
        return rateLimitService.isOverFrequency(rateLimitConfigDTO.getToken(), rateLimitConfigDTO.getVisits(), rateLimitConfigDTO.getTime(),
                rateLimitConfigDTO.getTimeUnit());
    }
}
