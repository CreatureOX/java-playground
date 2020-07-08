package com.creatureox.squirrel.dto.request;

import lombok.Data;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
@Data
public class UserActionRequestDTO {

    private Long userId;

    private String action;

}
