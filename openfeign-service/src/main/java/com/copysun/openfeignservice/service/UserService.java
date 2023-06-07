package com.copysun.openfeignservice.service;

import com.copysun.openfeignservice.domain.UserEntity;
import com.copysun.openfeignservice.fallback.UserImplFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author copysun
 * @Date: Create in 15:22 2022/6/15
 * @Desc
 */
@FeignClient(name = "nacos-service",fallback = UserImplFallback.class)
public interface UserService {
	@PostMapping("/get")
    UserEntity getUser(UserEntity userEntity);

	@PostMapping("/updateUser")
	void updateUser(UserEntity userEntity);
}
