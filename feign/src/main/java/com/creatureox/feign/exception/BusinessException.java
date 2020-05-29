package com.creatureox.feign.exception;

import com.creatureox.feign.enums.BusinessResponseCodeEnum;

/**
 * @author CreatureOX
 * date: 2020/5/28
 * description:
 */
public class BusinessException extends Exception {

    private String responseCode;

    private String responseMessage;

    public BusinessException(String responseCode, String responseMessage){
        super(responseMessage);
        this.responseCode = responseCode;
    }

    public BusinessException(BusinessResponseCodeEnum errorCodeEnum){
        this(errorCodeEnum.getResponseCode(), errorCodeEnum.getResponseMessage());
    }

}
