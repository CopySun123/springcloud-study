package com.copysun.interview.controller;

import com.copysun.interview.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author copysun
 * @Date: Create in 16:05 2023/1/31
 * @Desc
 */
@RestController
public class DemoController {

	@Resource
	private User user;

	@PostMapping("/test")
	public void test(){
		System.out.println(user.getName());
		System.out.println(user.getAge());
	}
}
