package com.copysun.mybatisservice.demo;

public interface TestInterface {

	default String pmethod() {
		System.out.println("private method in interface");
		return "private";
	}
}
