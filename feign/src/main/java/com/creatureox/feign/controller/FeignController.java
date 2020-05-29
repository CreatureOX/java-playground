package com.creatureox.feign.controller;

import com.creatureox.feign.dto.request.CommonRequestDTO;
import com.creatureox.feign.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author CreatureOX
 * date: 2020/5/28
 * description:
 */
@RestController
@RequestMapping("/feign")
@Slf4j
public class FeignController {

    @Resource
    private ApiService apiService;

    @GetMapping(value = "/get")
    public String get(@RequestParam("url") String url){
        return apiService.doGet(url);
    }

    @PostMapping(value = "/post")
    public String post(@RequestBody CommonRequestDTO requestDTO){
        return apiService.doPost(requestDTO);
    }

}
