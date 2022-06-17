package com.copysun.openfeignservice.controller;

import com.copysun.openfeignservice.entity.UserEntity;
import com.copysun.openfeignservice.outservice.impl.UserServiceImpl;
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
    private UserServiceImpl userServiceImpl;

	@PostMapping(value = "/get")
	@ResponseBody
	public UserEntity getUser(@RequestBody UserEntity userEntity){
		return userServiceImpl.getUser(userEntity);
	}

	@PostMapping(value = "/updateUser")
	@ResponseBody
	public void updateUser(@RequestBody UserEntity userEntity) throws Exception {
		userServiceImpl.updateUser(userEntity);
		//try {
		//	userServiceImpl.updateUser(userEntity);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
	}

}
