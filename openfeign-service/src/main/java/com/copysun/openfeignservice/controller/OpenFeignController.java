package com.copysun.openfeignservice.controller;

import com.copysun.openfeignservice.entity.UserEntity;
import com.copysun.openfeignservice.outservice.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author copysun
 * @Date: Create in 16:44 2022/6/10
 * @Desc
 */
@RestController
public class OpenFeignController {

	@Resource
	private UserService userService;

	@PostMapping(value = "/get")
	@ResponseBody
	public UserEntity getUser(@RequestBody UserEntity userEntity){

		return userService.getUser(userEntity);
	}

}
