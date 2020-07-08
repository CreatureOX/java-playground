package com.creatureox.squirrel.statemachine.state;

import lombok.Getter;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
@Getter
public enum StateEnum {
    /** state */
    INIT(0, "init", false),
    STARRED(1, "starred", false),
    FORKED(2, "forked", false),
    WATCHED(3, "watched", false),
    LOGOUT(4, "logout", true),
    ;

    private Integer code;

    private String desc;

    private boolean isLeaf;

    StateEnum(Integer code, String desc, boolean isLeaf){
        this.code = code;
        this.desc = desc;
        this.isLeaf = isLeaf;
    }


}
