package com.creatureox.memcached.controller;

import com.creatureox.memcached.dto.request.SetReqDTO;
import com.creatureox.memcached.service.MemcachedService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author heyifan
 * version: 1.0
 * date: 2020/9/27
 * description:
 */
@RequestMapping("/memcached")
@RestController
public class MemcachedController {

    @Resource
    private MemcachedService memcachedService;

    @PostMapping("/set")
    public ResponseEntity<Void> set(@Validated @RequestBody SetReqDTO setReqDTO){
        memcachedService.set(setReqDTO.getKey(), setReqDTO.getExpireSeconds(), setReqDTO.getObject());
        return ResponseEntity.ok(null);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> get(@RequestParam("key") String key){
        return ResponseEntity.ok(memcachedService.get(key));
    }
}

