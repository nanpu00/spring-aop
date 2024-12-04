package com.nanpu.springaop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Order(1)
public class OrderAspect {
    @Before("execution(public int com.nanpu.springaop.CalculatorImpl.*(..))")
    public void orderBeforeMethod(){
        log.info("order aspect：方法执行前");
    }
}
