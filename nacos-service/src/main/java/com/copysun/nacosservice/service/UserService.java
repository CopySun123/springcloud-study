package com.copysun.nacosservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.copysun.nacosservice.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author copysun
 * @Date: Create in 15:46 2022/6/10
 * @Desc
 */
public interface UserService extends IService<UserEntity> {


	/**
	 * 查询列表
	 * @return
	 */
	List<UserEntity> getList(Map<String,Object> param);

	/**
	 * 添加单个用户
	 * @param userEntity
	 */
	void add(UserEntity userEntity);


	/**
	 * 查询单个用户
	 * @param userEntity
	 * @return
	 */
	UserEntity getOne(UserEntity userEntity);

	/***
	 * 分页查询
	 * @param param
	 * @return
	 */
	Page<UserEntity> getListPage(Map<String,Object> param);


	/**
	 * 删除用户
	 * @param userEntity
	 */
	void delUser(UserEntity userEntity);
}
