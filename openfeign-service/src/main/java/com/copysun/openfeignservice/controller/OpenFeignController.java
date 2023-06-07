package com.copysun.openfeignservice.controller;

import com.copysun.common.vo.ResultCode;
import com.copysun.common.vo.ResultVo;
import com.copysun.openfeignservice.config.UserBean;
import com.copysun.openfeignservice.domain.UserEntity;
import com.copysun.openfeignservice.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class OpenFeignController {

	@Resource
	private UserBean userBean;
	@Resource
    private UserServiceImpl userServiceImpl;

	@PostMapping(value = "/get")
	@ResponseBody
	public UserEntity getUser(@RequestBody UserEntity userEntity){
		return userServiceImpl.getUser(userEntity);
	}

	@PostMapping(value = "/updateUser")
	@ResponseBody
	public ResultVo updateUser(@RequestBody UserEntity userEntity) {
		//System.out.println(userBean.getUserName());
		//System.out.println(userBean.getAge());
		try{
			userServiceImpl.updateUser(userEntity);
			return new ResultVo(ResultCode.SUCCESS);
		}catch (Exception e){
			log.error(e.getMessage());
			return new ResultVo(ResultCode.FAILED);
		}


	}

}
