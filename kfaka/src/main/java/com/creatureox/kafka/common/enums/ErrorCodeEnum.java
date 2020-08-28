package com.creatureox.kafka.common.enums;

import lombok.Getter;

/**
 * @author CreatureOX
 * date: 2020/8/16
 * description:
 */
@Getter
public enum ErrorCodeEnum {
    /**
     * error code enum
     */
    SYSTEM_ERROR("-1","system error"),
    ;

    private final String errorCode;
    private final String errorMessage;

    ErrorCodeEnum(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
