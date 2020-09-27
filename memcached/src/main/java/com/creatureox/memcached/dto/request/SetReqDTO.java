package com.creatureox.memcached.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author heyifan
 * version: 1.0
 * date: 2020/9/27
 * description:
 */
@Data
public class SetReqDTO {

    @ApiModelProperty("key")
    @NotBlank
    private String key;

    @ApiModelProperty("expire seconds")
    private Integer expireSeconds;

    @ApiModelProperty("object")
    @NotNull
    private Object object;

}
