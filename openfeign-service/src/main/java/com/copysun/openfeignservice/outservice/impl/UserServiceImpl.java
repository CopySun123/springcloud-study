package com.copysun.openfeignservice.outservice.impl;

import com.copysun.openfeignservice.entity.UserEntity;
import com.copysun.openfeignservice.outservice.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author copysun
 * @Date: Create in 18:52 2022/6/15
 * @Desc
 */
@Service
public class UserServiceImpl {
	@Resource
	private UserService userService;

	public UserEntity getUser(UserEntity userEntity){
		return userService.getUser(userEntity);
	}


	/**
	 * 测试分布式事务
	 * @param userEntity
	 */
	public void updateUser(UserEntity userEntity){
		userService.updateUser(userEntity);
		//int i=1/0;
	}

}