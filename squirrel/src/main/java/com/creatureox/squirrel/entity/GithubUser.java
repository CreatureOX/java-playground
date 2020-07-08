package com.creatureox.squirrel.entity;

import lombok.Data;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
@Data
public class GithubUser {

    private Long userId;

    private String name;

    private Integer state;

    private String stateDesc;

}
