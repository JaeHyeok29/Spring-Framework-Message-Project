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


/*
package com.nhnacademy.edu.springframework.aspect;

import com.nhnacademy.edu.springframework.messagesender.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect // Aspect 클래스임을 나타냄
@Component // spring이 이 클래스를 bean으로 관리하도록 지정
public class LoggingAspect { // Aspect를 정의하여 메소드 실행 전후에 로깅을 추가흔 역할

    // Pointcut을 정의, MessageSender 인터페이스를 구현한 클래스의 sendMessage 메소드 대상으로 한다.
    @Pointcut("execution(* com.nhnacademy.edu.springframework.messagesender.service.DoorayMessageSender.sendMessage(..))")
    public void logUserParameter() {}

    @Around("logUserParameter()")
    public Object doMessageLog (ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try{
            return pjp.proceed();
        }catch (Throwable e) {
            throw e;
        }finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

}

이방식과 너가 알려준 방식의 차이는 뭔데? 친구의 코드는 이렇게 작성했고 이런시으로 해야 하는 것 같아! 이렇게 작성해야하지 않아?
 */