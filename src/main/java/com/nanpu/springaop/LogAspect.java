package com.nanpu.springaop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {
    // 前置通知
    @Before("execution( public int com.nanpu.springaop.CalculatorImpl.*(..) )")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("前置通知,方法名:{},参数:{}", methodName, args);
    }

    // 返回通知
    @AfterReturning(value = "execution(* com.nanpu.springaop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        log.info("返回通知:方法名:{},结果:{}", methodName, result);
    }

    // 异常通知
    @AfterThrowing(value = "execution(* com.nanpu.springaop.CalculatorImpl.*(..))", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        String methodName = joinPoint.getSignature().getName();
        log.info("异常通知:参数:{},异常:{}", methodName, throwable.getMessage());
    }

    //后置通知
    @After("execution(* com.nanpu.springaop.CalculatorImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        log.info("后置通知:方法名:{},参数:{}", methodName, args);
    }

    @Around( "execution(* com.nanpu.springaop.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            log.info("环绕通知-方法执行前");
            result = joinPoint.proceed();
            log.info("环绕通知-方法返回后");
        } catch (Throwable throwable) {
            log.info("环绕通知--方法出现异常");
        } finally {
            log.info("环绕通知-方法执行完毕");
        }
        return result;
    }
}
