package com.copysun.nacosservice.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.copysun.nacosservice.entity.BaseEntity;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @Author copysun
 * @Date: Create in 17:24 2022/6/10
 * @Desc 填充添加、修改的创建人、创建时间、修改人、修改时间
 */
@Configuration
public class MyBatisMetaHandle implements MetaObjectHandler {

	/**
	 * 当字段添加 fill = FieldFill.INSERT 触发
	 * @param metaObject
	 */
	public void insertFill(MetaObject metaObject) {
          if(metaObject.getOriginalObject() instanceof BaseEntity){
	          metaObject.setValue("createTime",new Date());
	          metaObject.setValue("createUser","copysun1");
          }
	}

	/**
	 * 当字段添加 FieldFill.UPDATE 触发
	 * @param metaObject
	 */
	public void updateFill(MetaObject metaObject) {
		if(metaObject.getOriginalObject() instanceof BaseEntity){
			metaObject.setValue("updateTime",new Date());
			metaObject.setValue("updateUser","copysun2");
		}
	}
}
