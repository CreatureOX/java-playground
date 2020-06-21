package com.creatureox.redisson.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.redisson.api.RateIntervalUnit;

/**
 * @author CreatureOX
 * date: 2020/6/21
 * description:
 */
@Data
public class RateLimitConfigDTO {

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("visits")
    private Long visits;

    @ApiModelProperty("time")
    private Long time;

    @ApiModelProperty("timeUnit")
    private RateIntervalUnit timeUnit;

}
