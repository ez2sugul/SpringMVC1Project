package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

//@Service("afterReturning")
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) { 
		String method = jp.getSignature().getName();	
		
		System.out.println("[사후 처리] " + method + 
			"() 메서드 리턴 값 : " + returnObj.toString());
	}
	
}
