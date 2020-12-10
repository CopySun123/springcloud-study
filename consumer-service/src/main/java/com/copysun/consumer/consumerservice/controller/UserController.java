package com.copysun.consumer.consumerservice.controller;

import com.copysun.consumer.consumerservice.entity.UserEntity;
import com.copysun.consumer.consumerservice.service.UserEntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author CopySun
 * @date 2020/11/30 17:59
 */
@RestController
public class UserController {

    @Resource
    private UserEntityService userEntityService;

    @GetMapping("/add")
    public void add(){
        userEntityService.addUser();
    }


    @PostMapping(value = "/get")
    public UserEntity getUser(@RequestBody UserEntity user){
        UserEntity userEntity = userEntityService.getUser(user.getId());
        return userEntity;
    }

    @PostMapping(value = "/getMap")
    public Map<String, Object> getUserMap(@RequestBody UserEntity user){
        return userEntityService.getUserMap(user.getId());
    }

    @PostMapping(value = "/update")
    public void updateUser(@RequestBody UserEntity user){
        userEntityService.updateUser(user);
    }

    @PostMapping(value = "/del")
    public void delUser(@NotNull @RequestBody UserEntity user){
        userEntityService.delUser(user.getId());
    }
}
