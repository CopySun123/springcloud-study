package com.copysun.openfeignservice.fallback;

import com.copysun.openfeignservice.entity.UserEntity;
import com.copysun.openfeignservice.outservice.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author copysun
 * @Date: Create in 16:04 2022/6/15
 * @Desc
 */
@Service
public class UserFallbackImpl implements UserService {
	public UserEntity getUser(UserEntity userEntity) {
		throw new RuntimeException("远程调用失败---------------");
		//throw new Error("远程调用失败---------------");
		//System.out.println("远程调用失败---------------");
	}

	public void updateUser(UserEntity userEntity) {
		System.out.println("远程修改失败---------");
	}
}
