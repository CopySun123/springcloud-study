package com.copysun.common.vo;

import lombok.Getter;

/**
 * @Author copysun
 * @Date: Create in 15:45 2022/6/21
 * @Desc
 */
@Getter
public enum ResultCode implements StatusCode{
	SUCCESS(1000,"处理成功"),
	FAILED(1001,"处理失败"),
	VALIDATE_ERROR(1002, "参数校验失败"),
	RESPONSE_PACK_ERROR(1003, "VO返回包装失败"),
	REMOTE_CAL_ERROR(1004,"远程调用失败")
	;
    private final int code;
	private final String msg;

	ResultCode(int code, String msg){
		this.code = code;
		this.msg = msg;
	}

}
