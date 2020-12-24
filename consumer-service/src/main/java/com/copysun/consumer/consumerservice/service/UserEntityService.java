package com.copysun.consumer.consumerservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.copysun.consumer.consumerservice.entity.UserEntity;
import com.copysun.consumer.consumerservice.mapper.UserEntityMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author CopySun
 * @date 2020/11/30 17:33
 */
@Service
public class UserEntityService extends ServiceImpl<UserEntityMapper, UserEntity> {
    /**
     * 添加用户
     */
    public void addUser() {
        List<UserEntity> userEntities = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setAge(i);
            userEntity.setName("copysun" + i);
            userEntities.add(userEntity);
        }
        this.saveBatch(userEntities);
    }

    /**
     * 查询单个用户（添加缓存）,返回实体对象
     *
     * @param userId
     * @return
     */
    @Cacheable(cacheNames = "userServiceCache", key = "'user:'+#userId")
    public UserEntity getUser(String userId) {
        UserEntity userEntity = this.getById(userId);
        return userEntity;
    }

    /**
     * 查询单个用户（添加缓存）,返回Map
     *
     * @param userId
     * @return
     */
//    @Cacheable(cacheNames = "userServiceCache", key = "'user:'+#userId")
    public Map<String,Object> getUserMap(String userId) {
        Map<String, Object> userMap = this.getMap(new QueryWrapper<UserEntity>());
        return userMap;
    }

    /**
     * 修改用户（修改缓存）
     *
     * @param user
     * @return
     */
    @CachePut(cacheNames = "userServiceCache", key = "#user.id")
    public UserEntity updateUser(UserEntity user) {
        this.updateById(user);

        //基于SpringAOP原理，同类中的方法调用会导致切面失效，因此这里会使getUser的缓存注解会失效
        UserEntity userEntity = this.getUser(user.getId());
        return userEntity;
    }

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    @CacheEvict(cacheNames = "userServiceCache", key = "#userId", beforeInvocation = true)
    public void delUser(String userId) {
        this.removeById(userId);
    }

}

