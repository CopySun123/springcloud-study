package com.copysun.mybatisservice.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Pointcut("@annotation(com.copysun.mybatisservice.annation.MyTest)")
	public void log(){

	}

	@Around("log()")
	public Object aroundLog(ProceedingJoinPoint point){
		System.out.println("进来了。。。");
		Object obj=null;
		try {
			obj=point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}

}
