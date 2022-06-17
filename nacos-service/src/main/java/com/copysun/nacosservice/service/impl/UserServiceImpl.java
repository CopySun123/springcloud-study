package com.copysun.nacosservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.copysun.nacosservice.entity.UserEntity;
import com.copysun.nacosservice.mapper.UserMapper;
import com.copysun.nacosservice.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author copysun
 * @Date: Create in 15:46 2022/6/10
 * @Desc
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements UserService  {

	public List<UserEntity> getList(Map<String,Object> param) {
		return this.list();
	}

	public void add(UserEntity userEntity) {
		this.save(userEntity);
	}

	/**
	 * 查询单个  添加缓存
	 * @param userEntity
	 * @return
	 */
	@Cacheable(cacheNames="userGetOneCache",key = "'user:'+#userEntity.id")
	public UserEntity getOne(UserEntity userEntity) {
		return this.getBaseMapper().selectOne(new LambdaQueryWrapper<UserEntity>());
	}

	public Page<UserEntity> getListPage(Map<String, Object> param) {
		Page<UserEntity> page=new Page<UserEntity>(10,1);
		return this.getBaseMapper().selectPage(page,new QueryWrapper<UserEntity>());
	}

	public void delUser(UserEntity userEntity) {
		this.removeById(userEntity);
	}
}
