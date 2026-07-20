package com.zeus.common.aop;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class ServiceLoggerAdvice {
	// joinPoint = 멤버함수 * * (..)
	@Before("execution(* com.zeus.service.BoardService*.*(..))")
	public void startLog(JoinPoint jp) {
		Date date = new Date();
		log.info("*******start log : " + date.toString());
		log.info("*******start log : " + jp.getSignature());
		log.info("*******start log : " + Arrays.toString(jp.getArgs()));
	}
	
	@AfterReturning(pointcut = "execution(* com.zeus.service.BoardService*.*(..))", returning = "result")
	public void returningLog(JoinPoint jp, Object result) {
		log.info("***Returning log : " + jp.getSignature());
		log.info("***Returning log : " + result);
	}
	
	// http://127.0.0.1:8080/board/select?boardNo=99999
	@AfterThrowing(pointcut = "execution(* com.zeus.service.BoardService*.*(..))", throwing = "e")
	public void throwingLog(JoinPoint jp, Exception e) {
		log.info("****Throwing log : " + jp.getSignature());
		log.info("****Throwing log : " + e);
	}
	
	@After("execution(* com.zeus.service.BoardService*.*(..))")
	public void afterLog(JoinPoint jp) {
		log.info("*******After log : " + jp.getSignature());
		log.info("*******start log : " + Arrays.toString(jp.getArgs()));
	}
	
	@Around("execution(* com.zeus.service.BoardService*.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		
		log.info("******Around log : " + pjp.getSignature());
		log.info("******Around log : " + Arrays.toString(pjp.getArgs()));
		Object result = pjp.proceed();
					
		long stopTime = System.currentTimeMillis();
		log.info("******Around log : " + pjp.getSignature().getName() + " = " + (stopTime - startTime));

		return result;
	}
	
}
