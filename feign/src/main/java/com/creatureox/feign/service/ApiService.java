package com.creatureox.feign.service;

import com.creatureox.feign.dto.request.CommonRequestDTO;

/**
 * @author CreatureOX
 * date: 2020/5/28
 * description:
 */
public interface ApiService {

    /**
     * do get
     *
     * @param url url
     * @return response
     */
    String doGet(String url);

    /**
     * do post
     *
     * @param requestDTO common request
     * @return response
     */
    String doPost(CommonRequestDTO requestDTO);

}
