package com.copysun.nacosservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.copysun.nacosservice.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author copysun
 * @Date: Create in 15:48 2022/6/10
 * @Desc
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
