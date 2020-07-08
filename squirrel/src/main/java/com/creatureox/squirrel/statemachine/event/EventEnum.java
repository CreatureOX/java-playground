package com.creatureox.squirrel.statemachine.event;

/**
 * @author CreatureOX
 * version: 1.0
 * date: 2020/7/8
 * description:
 */
public enum EventEnum {
    /** event */
    WATCH,
    STAR,
    FORK,
    UNWATCH,
    UNSTAR,
    UNFORK,
    LEAVE,
    ;

    public static EventEnum fromUserAction(String action){
        if ("WATCH".equals(action)){
            return WATCH;
        }else if ("STAR".equals(action)){
            return STAR;
        }else if ("FORK".equals(action)){
            return FORK;
        }else if ("UNWATCH".equals(action)){
        return UNWATCH;
        }else if ("UNSTAR".equals(action)){
            return UNSTAR;
        }else if ("UNFORK".equals(action)){
            return UNFORK;
        }else if ("LEAVE".equals(action)){
            return LEAVE;
        }else {
            return null;
        }
    }

}
