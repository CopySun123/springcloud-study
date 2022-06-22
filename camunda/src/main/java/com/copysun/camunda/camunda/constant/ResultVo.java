package com.copysun.camunda.camunda.constant;

import lombok.Data;

/**
 * @Author copysun
 * @Date: Create in 15:52 2022/6/21
 * @Desc  返回通用结果集对象
 */
@Data
public class ResultVo {
	/**
	 * 状态码
	 */
	private int code;

	/**
	 * 状态信息
	 */
	private String msg;

	/**
	 * 返回对象
	 */
	private Object data;

	/**
	 * 无参构造
	 */
	public ResultVo(){

	}
	/**
	 * 手动设置返回所有参数
	 * @param code
	 * @param msg
	 * @param data
	 */
	public ResultVo(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 默认返回成功，以及数据
	 * @param data
	 */
	public ResultVo(Object data) {
		this.code = ResultCode.SUCCESS.getCode();
		this.msg = ResultCode.SUCCESS.getMsg();
		this.data = data;
	}

	/**
	 * 返回指定状态码，数据对象
	 * @param statusCode
	 * @param data
	 */
	public ResultVo(StatusCode statusCode, Object data) {
		this.code = statusCode.getCode();
		this.msg = statusCode.getMsg();
		this.data = data;
	}

	/**
	 * 只返回状态码
	 * @param statusCode
	 */
	public ResultVo(StatusCode statusCode) {
		this.code = statusCode.getCode();
		this.msg = statusCode.getMsg();
		this.data = null;
	}


	/**
	 * 只返回状态码
	 * @param code
	 * @param msg
	 */
	public ResultVo(int code, String msg) {
		this.code = code;
		this.msg = msg;
		this.data = null;
	}


}
