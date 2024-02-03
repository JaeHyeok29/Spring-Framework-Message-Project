package com.nhnacademy.edu.springframework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.nhnacademy.edu.springframework.DoorayMessageSender.sendMessage(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        long executionTime = stopWatch.getTotalTimeMillis();
        System.out.println(className + "." + methodName + " " + executionTime + "ms");

        return result;


    }
}
