package com.copysun.mybatisservice.config;

import com.copysun.mybatisservice.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author copysun
 * 添加拦截器配置
 */
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor())
				.addPathPatterns("/**");
	}
}
