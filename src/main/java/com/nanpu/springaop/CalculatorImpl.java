package com.nanpu.springaop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        int result = a + b;
        log.info("add方法内，result:{}", result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a - b;
        log.info("sub方法内，result:{}", result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = a * b;
        log.info("mul方法内，result:{}", result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = a / b;
        log.info("div方法内，result:{}", result);
        return result;
    }
}
