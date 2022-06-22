package com.copysun.camunda.camunda.controller;

import com.copysun.camunda.camunda.constant.ResultVo;
import com.copysun.camunda.camunda.entity.ProductInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author copysun
 * @Date: Create in 15:58 2022/6/21
 * @Desc
 */
@RestController
@Api(tags = "测试类")
public class TestController {


	@PostMapping("/test")
	@ResponseBody
	@ApiOperation(value = "测试参数校验",notes = "测试参数校验")
	public ResultVo test(@RequestBody @Valid ProductInfoVo vo){
		System.out.println(vo.getProductName());
		System.out.println(vo.getProductPrice());
		return new ResultVo();
	}
}
