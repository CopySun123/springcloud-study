package com.copysun.mybatisservice.demo;

public class TestDemo {
	private static TestInterface testInterfaceImpl=new TestInterfaceImpl();
	public static void main(String[] args) {
		testInterfaceImpl.pmethod();
	}
}
