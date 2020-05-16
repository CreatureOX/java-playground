package com.creatureox.shardingsphere.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author CreatureOX
 * date: 2020/5/16
 * description:
 */
@Data
public class CreateUserDTO {

    @ApiModelProperty("name")
    @NotBlank
    private String name;

}
