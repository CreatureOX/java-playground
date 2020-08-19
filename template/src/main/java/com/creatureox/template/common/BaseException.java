package com.creatureox.template.common;

import com.creatureox.template.common.enums.ErrorCodeEnum;

/**
 * @author CreatureOX
 * date: 2020/8/19
 * description:
 */
public class BaseException extends RuntimeException {

    private String errorCode;

    public BaseException() {

    }

    public BaseException(String errorMessage){
        super(errorMessage);
    }

    public BaseException(String errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrorMessage());
        this.errorCode = errorCodeEnum.getErrorCode();
    }

    public BaseException(Throwable cause){
        super(cause);
    }

    public BaseException(String errorMessage, Throwable cause){
        super(errorMessage, cause);
    }

    public String getErrorCode(){
        return this.errorCode;
    }

}
