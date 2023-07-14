package com.copysun.common.config.mybatisplus;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author copysun
 * @Date: Create in 14:40 2023/4/27
 * @Desc 解决yaml配置map-underscore-to-camel-case不生效问题
 */
@Configuration
public class CustomMapWrapperFactory {

	@Bean
	public ConfigurationCustomizer mapUnderscoreToCamelCase(){
		return configuration -> configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());
	}
}
