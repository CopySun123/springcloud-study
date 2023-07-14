package com.copysun.nacosdemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.copysun.common.vo.ResultCode;
import com.copysun.common.vo.ResultVo;
import com.copysun.nacosdemo.domain.TestBean;
import com.copysun.nacosdemo.entity.UserEntity;
import com.copysun.nacosdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author copysun
 * @Date: Create in 16:44 2022/6/10
 * @Desc
 */
@RestController
@Slf4j
public class UserController {

	@Resource
	TestBean testBean;
	@Resource
	UserService userService;


	@PostMapping(value = "/testBean")
	@ResponseBody
	public ResultVo testBean(){
		ResultVo resultVo;
		try{
			log.info("======用户名:{}======",testBean.getUserName());
			log.info("======密码:{}======",testBean.getPassword());
			resultVo=new ResultVo(ResultCode.SUCCESS);
		}catch (Exception e){
			log.error("======操作失败!======"+e.getMessage());
			resultVo=new ResultVo(ResultCode.FAILED);
			return resultVo;
		}
		return resultVo;
	}

	@PostMapping(value = "/listEntity")
	@ResponseBody
	public ResultVo getListEntity(@RequestBody Map<String,Object> param){
		ResultVo resultVo;
		try {
			log.info("======查询用户列表开始!======");
			List<UserEntity> list = userService.getListEntity(param);
			log.info("======查询用户列表成功!======");
			resultVo=new ResultVo(list);
		}catch (Exception e){
			log.error("======查询用户列表失败!======"+e.getMessage());
			resultVo=new ResultVo(ResultCode.FAILED);
			return resultVo;
		}
		return resultVo;
	}

	@PostMapping(value = "/listPage")
	@ResponseBody
	public ResultVo getListPage(@RequestBody Map<String,Object> param){
		ResultVo resultVo;
		try {
			log.info("======查询用户列表开始!======");
			Page<UserEntity> listPage = userService.getListPage(param);
			log.info("======查询用户列表成功!======");
			resultVo=new ResultVo(listPage);
		}catch (Exception e){
			log.error("======查询用户列表失败!======"+e.getMessage());
			resultVo=new ResultVo(ResultCode.FAILED);
			return resultVo;
		}
		return resultVo;
	}

	@PostMapping(value = "/listMap")
	@ResponseBody
	public ResultVo getListMap(@RequestBody Map<String,Object> param){
		ResultVo resultVo;
		try {
			log.info("======查询用户列表开始!======");
			List<Map<String, Object>> listMap = userService.getListMap(param);
			log.info("======查询用户列表成功!======");
			resultVo=new ResultVo(listMap);
		}catch (Exception e){
			log.error("======查询用户列表失败!======"+e.getMessage());
			resultVo=new ResultVo(ResultCode.FAILED);
			return resultVo;
		}
		return resultVo;
	}

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
