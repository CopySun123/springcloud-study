package com.copysun.nacosdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.copysun.nacosdemo.entity.UserEntity;
import com.copysun.nacosdemo.mapper.UserMapper;
import com.copysun.nacosdemo.service.UserService;
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

	@Override
	public List<UserEntity> getListEntity(Map<String, Object> param) {
		return this.baseMapper.selectList(new QueryWrapper<>());
	}

	@Override
	public List<Map<String, Object>> getListMap(Map<String, Object> param) {
		return this.baseMapper.selectMaps(new QueryWrapper<>());
	}

	public void add(UserEntity userEntity) {
		this.save(userEntity);
	}

	/**
	 * 查询单个  添加缓存
	 * @param userEntity
	 * @return
	 */
	//@Cacheable(cacheNames="userGetOneCache",key = "'user:'+#userEntity.id")
	public UserEntity getOne(UserEntity userEntity) {
		return this.getBaseMapper().selectOne(new LambdaQueryWrapper<>(userEntity));
	}

	public Page<UserEntity> getListPage(Map<String, Object> param) {
		Page<UserEntity> page=new Page<UserEntity>(10,1);
		return this.getBaseMapper().selectPage(page, new QueryWrapper<>());
	}

	public void delUser(UserEntity userEntity) {
		this.removeById(userEntity);
	}
}
