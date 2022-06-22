package com.copysun.camunda.camunda.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author copysun
 * @Date: Create in 13:41 2022/6/20
 * @Desc
 */
public class CopyListUtils {
		/**
		 * copyList
		 *
		 * @param sourceList
		 * @param targetClass
		 * @return
		 */
		public static <T> List<T> copyList(List<?> sourceList, Class<T> targetClass) {
			if (sourceList == null || CollectionUtils.isEmpty(sourceList)) {
				return new ArrayList<>();
			}
			return JSON.parseArray(JSON.toJSONString(sourceList), targetClass);
		}

	}
