package com.copysun.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @Author copysun
 * @Date: Create in 9:50 2023/4/28
 * @Desc
 */
public enum SexEnum {
	SEX_MAN("1","男")
	,SEX_WOMAN("0","女");

	@EnumValue
	//数据库保存的值
	String code;

	@JsonValue
	//入参或者出参的值
	String msg;

	SexEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "SexEnum{" +
				"code='" + code + '\'' +
				", msg='" + msg + '\'' +
				'}';
	}
}
