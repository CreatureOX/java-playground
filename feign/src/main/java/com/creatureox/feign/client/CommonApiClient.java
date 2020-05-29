package com.creatureox.feign.client;

import feign.Feign;
import feign.RequestInterceptor;
import feign.Target;
import feign.jackson.JacksonEncoder;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author CreatureOX
 * date: 2020/5/28
 * description:
 */
@Component
public class CommonApiClient {

    public String doGet(String url) throws URISyntaxException {
        return buildClient().doGet(new URI(url));
    }

    public String doPost(String url, Object body) throws URISyntaxException {
        return buildClient().doPost(new URI(url), body);
    }

    public String doPost(String url, Object body, Map<String, String> headers) throws URISyntaxException {
        return buildClient(headers).doPost(new URI(url), body);
    }

    private ApiFeignClient buildClient(){
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .errorDecoder(new CustomErrorDecoder())
                .target(Target.EmptyTarget.create(ApiFeignClient.class));
    }

    private ApiFeignClient buildClient(Map<String, String> headers){
        RequestInterceptor interceptor = requestTemplate -> headers.forEach(requestTemplate::header);
        return Feign.builder()
                .requestInterceptor(interceptor)
                .encoder(new JacksonEncoder())
                .errorDecoder(new CustomErrorDecoder())
                .target(Target.EmptyTarget.create(ApiFeignClient.class));
    }

}
