package com.creatureox.redisson.service;

import org.redisson.api.RateIntervalUnit;

/**
 * @author CreatureOX
 * date: 2020/6/21
 * description:
 */
public interface RateLimitService {

    /**
     * test token is over frequency
     *
     * @param token token token
     * @param visits visits during time
     * @param time time
     * @param timeUnit time unit
     * @return is over frequency
     */
    boolean isOverFrequency(String token, long visits, long time, RateIntervalUnit timeUnit);

}
