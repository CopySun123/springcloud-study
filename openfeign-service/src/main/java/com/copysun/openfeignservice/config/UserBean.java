package com.copysun.openfeignservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.Serializable;

/**
 * @Author copysun
 * @Date: Create in 15:01 2023/1/13
 * @Desc
 */
@ConfigurationProperties(UserBean._PREFIX)
@EnableConfigurationProperties(UserBean.class)
public class UserBean implements Serializable {
	public static final String _PREFIX = "user";
	private String userName;
	private String age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
