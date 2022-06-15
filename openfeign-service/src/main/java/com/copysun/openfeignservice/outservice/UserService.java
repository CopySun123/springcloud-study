package com.copysun.openfeignservice.outservice;

import com.copysun.openfeignservice.entity.UserEntity;
import com.copysun.openfeignservice.fallback.UserFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author copysun
 * @Date: Create in 15:22 2022/6/15
 * @Desc
 */
@FeignClient(name = "nacos-service",fallback = UserFallbackImpl.class)
public interface UserService {
	@PostMapping("/get")
    UserEntity getUser(UserEntity userEntity);
}
