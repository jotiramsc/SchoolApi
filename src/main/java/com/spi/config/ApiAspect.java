package com.spi.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ApiAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
	@Before("execution(* com.spi.services.*.*(..))")
	public void before(JoinPoint joinPoint){
		logger.info(" Before execution of {}", joinPoint.getSignature());
	}
	@After("execution(* com.spi.services.*.*(..))")
	public void after(JoinPoint joinPoint){
		logger.info(" After execution of {}", joinPoint.getSignature());
	}
}
