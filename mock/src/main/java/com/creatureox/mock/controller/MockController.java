package com.creatureox.mock.controller;

import com.creatureox.mock.common.config.MockConfig;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author CreatureOX
 * date: 2021/11/24
 * description:
 */
@RestController
public class MockController {

    @Resource
    private MockConfig mockConfig;

    @GetMapping(value = "/**", produces = {"application/json;charset=UTF-8"})
    public Object get(HttpServletRequest httpServletRequest, @RequestParam Map<String, Object> requestMap) {
        if (Objects.isNull(mockConfig.getResponse()) || mockConfig.getResponse().isEmpty()) {
            return null;
        }
        return mockConfig.getResponse().get(httpServletRequest.getServletPath());
    }

    @PostMapping(value = "/**", produces = {"application/json;charset=UTF-8"})
    public Object post(HttpServletRequest httpServletRequest, @RequestBody Object requestBody) {
        if (Objects.isNull(mockConfig.getResponse()) || mockConfig.getResponse().isEmpty()) {
            return null;
        }
        return mockConfig.getResponse().get(httpServletRequest.getServletPath());
    }

}
