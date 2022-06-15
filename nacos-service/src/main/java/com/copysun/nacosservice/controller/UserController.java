package com.copysun.nacosservice.controller;

import com.copysun.nacosservice.entity.UserEntity;
import com.copysun.nacosservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author copysun
 * @Date: Create in 16:44 2022/6/10
 * @Desc
 */
@RestController
public class UserController {

	@Resource
	UserService userService;

	@PostMapping(value = "/addUser")
	@ResponseBody
	public void addUser(@RequestBody UserEntity userEntity){
		userService.add(userEntity);
		System.out.println("添加成功!");
	}


	@PostMapping(value = "/get")
	@ResponseBody
	public UserEntity getUser(@RequestBody UserEntity userEntity){
		UserEntity user = userService.getOne(userEntity);
		System.out.println("查询单个用户成功!");
		return user;
	}

	@PostMapping(value = "/updateUser")
	public void updateUser(@RequestBody UserEntity userEntity){
		userService.updateById(userEntity);
		System.out.println("修改成功!");
	}



	@PostMapping(value = "/del")
	public void delUser(@RequestBody UserEntity userEntity){
		userService.delUser(userEntity);
		System.out.println("删除成功!");
	}
}
