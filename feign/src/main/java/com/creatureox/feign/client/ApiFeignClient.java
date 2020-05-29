package com.creatureox.feign.client;

import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.net.URI;

/**
 * @author CreatureOX
 * date: 2020/5/28
 * description:
 */
@FeignClient(name = "apiFeignClient")
@Headers({"Content-Type: application/json","Accept: application/json"})
public interface ApiFeignClient {

    /**
     * execute get
     *
     * @param uri url
     * @return response
     */
    @RequestLine("GET")
    String doGet(URI uri);

    /**
     * execute post
     *
     * @param uri url
     * @param body request body
     * @return response
     */
    @RequestLine("POST")
    String doPost(URI uri, Object body);

}
