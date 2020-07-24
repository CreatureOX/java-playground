package com.creatureox.security.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CreatureOX
 * date: 2020/7/22
 * description:
 */
@RestController
@Api(value = "demo")
public class DemoController {

    @GetMapping("/guest/echo")
    public String guestEcho(@RequestParam(value = "word") String word) {
        return "GUEST:" + word;
    }

    @GetMapping("/admin/echo")
    public String adminEcho(@RequestParam(value = "word") String word) {
        return "ADMIN:" + word;
    }

    @GetMapping("/authenticated/echo")
    public String authenticatedEcho(@RequestParam(value = "word") String word) {
        return "AUTHENTICATED:" + word;
    }

    @GetMapping("/permission1/echo")
    public String permission1Echo(@RequestParam(value = "word") String word) {
        return "PERMISSION1:" + word;
    }

    @GetMapping("/permission2/echo")
    public String permission2Echo(@RequestParam(value = "word") String word) {
        return "PERMISSION2:" + word;
    }

    @GetMapping("/permission3/echo")
    public String permission3Echo(@RequestParam(value = "word") String word) {
        return "PERMISSION3:" + word;
    }

    @GetMapping("/permission4/echo")
    public String permission4Echo(@RequestParam(value = "word") String word) {
        return "PERMISSION4:" + word;
    }

}
