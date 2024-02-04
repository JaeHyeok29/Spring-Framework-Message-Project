package com.nhnacademy.edu.springframework;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExecutionTimeLogger {

    private static final Logger logger = LoggerFactory.getLogger(MethodExecutionTimeLogger.class);

    @Around("@annotation(com.nhnacademy.edu.springframework.MonitorExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        logger.info("{} {}ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }
}
