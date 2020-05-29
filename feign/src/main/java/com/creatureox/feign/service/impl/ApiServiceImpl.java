package com.creatureox.feign.service.impl;

import com.creatureox.feign.client.CommonApiClient;
import com.creatureox.feign.dto.request.CommonRequestDTO;
import com.creatureox.feign.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author CreatureOX
 * date: 2020/5/29
 * description:
 */
@Slf4j
@Service
public class ApiServiceImpl implements ApiService {

    @Resource
    private CommonApiClient commonApiClient;

    @Override
    public String doGet(String url) {
        try {
            return commonApiClient.doGet(url);
        }catch (URISyntaxException e){
            log.error("URISyntaxException: ", e);
            return "";
        }
    }

    @Override
    public String doPost(CommonRequestDTO requestDTO) {
        try {
            Map<String, String> headers = requestDTO.getHeaders();
            if (headers ==null || headers.isEmpty()){
                return commonApiClient.doPost(requestDTO.getUrl(), requestDTO.getRequestBody());
            }
            return commonApiClient.doPost(requestDTO.getUrl(), requestDTO.getRequestBody(), requestDTO.getHeaders());
        }catch (URISyntaxException e){
            log.error("URISyntaxException: ", e);
            return "";
        }
    }

}
