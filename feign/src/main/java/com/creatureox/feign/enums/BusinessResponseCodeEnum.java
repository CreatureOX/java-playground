package com.creatureox.feign.enums;

import lombok.Getter;

/**
 * @author CreatureOX
 * date: 2020/5/28
 * description:
 */
@Getter
public enum BusinessResponseCodeEnum {
    /** response code enum */
    SUCCESS("0", "success"),
    FAIL("1","fail")
    ;

    private final String responseCode;

    private final String responseMessage;

    BusinessResponseCodeEnum(String responseCode, String responseMessage){
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

}
