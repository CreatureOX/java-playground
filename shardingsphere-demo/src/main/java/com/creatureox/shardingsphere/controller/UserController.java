package com.creatureox.shardingsphere.controller;

import com.creatureox.shardingsphere.dto.request.CreateUserDTO;
import com.creatureox.shardingsphere.dto.request.UpdateUserDTO;
import com.creatureox.shardingsphere.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author CreatureOX
 * date: 2020/5/16
 * description:
 */
@RestController
@RequestMapping("/user")
@Api(value = "user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation("get")
    @GetMapping("/get/{id}")
    public String get(@ApiParam("id") @PathVariable Long id) {
        return userService.get(id).toString();
    }

    @ApiOperation("create")
    @PostMapping("/create")
    public void create(@ApiParam("user") @Validated @RequestBody CreateUserDTO createUserDTO) {
        userService.insert(createUserDTO);
    }

    @ApiOperation("update")
    @PostMapping("/update")
    public void update(@ApiParam("user") @Validated @RequestBody UpdateUserDTO updateUserDTO) {
        userService.update(updateUserDTO);
    }

}
