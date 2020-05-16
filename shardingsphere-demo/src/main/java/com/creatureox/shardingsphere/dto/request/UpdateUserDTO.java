package com.creatureox.shardingsphere.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author CreatureOX
 * date: 2020/5/16
 * description:
 */
@Data
public class UpdateUserDTO {

    @ApiModelProperty("id")
    @NotNull
    private Long id;

    @ApiModelProperty("name")
    private String name;

}
