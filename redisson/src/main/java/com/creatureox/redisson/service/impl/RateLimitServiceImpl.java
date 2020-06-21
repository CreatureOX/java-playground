package com.creatureox.redisson.service.impl;

import com.creatureox.redisson.service.RateLimitService;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/6/21
 * description:
 */
@Service
public class RateLimitServiceImpl implements RateLimitService {

    private static final String RATE_LIMITER = "RATE_LIMITER";

    @Resource
    private RedissonClient redissonClient;

    @Override
    public boolean isOverFrequency(String token,  long visits, long time, RateIntervalUnit timeUnit) {
        String key = String.format("%s:%s", RATE_LIMITER, token);
        RRateLimiter rateLimiter = redissonClient.getRateLimiter(key);
        rateLimiter.trySetRate(RateType.OVERALL, visits, time, timeUnit);
        return rateLimiter.tryAcquire(1);
    }
}
