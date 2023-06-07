package com.copysun.interview.reflection;

import com.copysun.interview.domain.User;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @Author copysun
 * @Date: Create in 9:20 2023/2/1
 * @Desc 学习反射知识
 */
public class Demo {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<User> aClass = (Class<User>) Class.forName("com.copysun.interview.domain.User");
		Arrays.stream(aClass.getFields()).forEach(field -> {
			System.out.println(field);
		});

		Arrays.stream(aClass.getMethods()).forEach(method -> {
			System.out.println(method.getName());
		});

		Arrays.stream(aClass.getConstructors()).forEach(constructor -> {
			System.out.println();
		});

		for (int i = 0; i <aClass.getFields().length ; i++) {
			Field field = aClass.getFields()[i];
			System.out.println(field.getName());
			System.out.println(field.getType());
		}
	}
}
