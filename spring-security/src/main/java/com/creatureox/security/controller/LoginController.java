package com.creatureox.security.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author CreatureOX
 * date: 2020/7/22
 * description:
 */
@Controller
@Api(value = "login")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "LOGIN";
    }

}
