package com.example.demo.aop;

import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	private static final Logger log = LoggerFactory.getLogger(MyAspect.class);

//	@Before("execution(* com.example.demo.aop.TargetObject.*(..))")
//	@Before("execution(* com.example.demo.aop.TargetObject.hello(..))")
//	public void before() {
//		log.info("..:: before advise ::..");
//	}

	@Before("execution(* com.example.demo.aop.TargetObject.*(..))")
	public void before(JoinPoint joinPoint) {
		log.info("..:: before advise ::..");
		log.info("Method name: {}", joinPoint.getSignature().getName());
		log.info("Object type: {}", joinPoint.getSignature().getDeclaringTypeName());
		log.info("Modifiers: {}", joinPoint.getSignature().getModifiers());
		log.info("Is public: {}", Modifier.isPublic(joinPoint.getSignature().getModifiers()));
		log.info("Arguments: {}", joinPoint.getArgs());
	}

}
