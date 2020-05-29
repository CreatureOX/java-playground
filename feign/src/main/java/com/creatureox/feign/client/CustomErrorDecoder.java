package com.creatureox.feign.client;

import com.creatureox.feign.enums.BusinessResponseCodeEnum;
import com.creatureox.feign.exception.BusinessException;
import com.creatureox.feign.utils.ConfigUtil;
import com.creatureox.feign.utils.HttpUtil;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * @author CreatureOX
 * date: 2020/5/28
 * description:
 */
@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String host = HttpUtil.getHost(response.request().url());
        if (ConfigUtil.specialHostList.contains(host) && response.status() != HttpStatus.OK.value()){
            try {
                String responseJson = Util.toString(response.body().asReader());
                return new BusinessException(BusinessResponseCodeEnum.SUCCESS.getResponseCode(), responseJson);
            }catch (IOException e){
                log.error("IOException: ", e);
                return new BusinessException(BusinessResponseCodeEnum.FAIL);
            }
        }
        return feign.FeignException.errorStatus(methodKey, response);
    }

}
