package com.copysun.mybatisservice.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author copysun
 */
@Component
public class DateFillHandler implements MetaObjectHandler {


	/**
	 * 添加数据自动维护添加事件字段
	 * @param metaObject
	 */
	@Override
	public void insertFill(MetaObject metaObject) {
          this.strictInsertFill(metaObject,"createTime", LocalDateTime::now,LocalDateTime.class);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.strictUpdateFill(metaObject,"updateTime", LocalDateTime::now,LocalDateTime.class);
	}
}
