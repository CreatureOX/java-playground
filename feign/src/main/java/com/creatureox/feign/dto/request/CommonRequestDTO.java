package com.creatureox.feign.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author CreatureOX
 * date: 2020/5/28
 * description:
 */
@Data
public class CommonRequestDTO {

    @ApiModelProperty("url")
    private String url;

    @ApiModelProperty("headers")
    private Map<String, String> headers;

    @ApiModelProperty("params")
    private Map<String, String> params;

    @ApiModelProperty("requestBody")
    private Object requestBody;

}
