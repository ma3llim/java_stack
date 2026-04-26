package com.sameer.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMoniterAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMoniterAspect.class);

    @Around("execution(* com.sameer.spring_boot_rest..*(..))")
    public Object monitorTimer(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        LOGGER.info("Time Taken By: " + joinPoint.getSignature().getName() + ": " + (endTime-startTime) + "ms");
        return obj;
    }
}
