package com.copysun.consumer.consumerservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.copysun.consumer.consumerservice.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author CopySun
 * @date 2020/12/4 17:16
 * @Description
 */
@Mapper
public interface UserEntityMapper extends BaseMapper<UserEntity> {
    UserEntity getUser(String id);
}