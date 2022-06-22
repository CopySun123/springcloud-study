package com.copysun.camunda.camunda.exception;

import com.copysun.camunda.camunda.constant.ResultCode;
import com.copysun.camunda.camunda.constant.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @Author copysun
 * @Date: Create in 16:19 2022/6/21
 * @Desc
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

	@ExceptionHandler({MethodArgumentNotValidException.class})
	//@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResultVo validateException(MethodArgumentNotValidException ex){
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		StringBuilder sb=new StringBuilder();
		fieldErrors.forEach(fieldError -> {
			sb.append(fieldError.getDefaultMessage()+"\r\n");
		});
		log.info(sb.toString());
		return new ResultVo(ResultCode.VALIDATE_ERROR.getCode(), String.valueOf(sb));
	}
}
