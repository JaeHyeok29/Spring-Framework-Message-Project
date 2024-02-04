package com.nhnacademy.edu.springframework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTimeAspect {

    @Around("@annotation(com.nhnacademy.edu.springframework.MeasureExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println(joinPoint.getSignature() + " " + executionTime + "ms");
        return result;
    }
}
