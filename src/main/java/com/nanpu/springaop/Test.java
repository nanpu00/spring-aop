package com.nanpu.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Calculator calculator =  ac.getBean(Calculator.class);
        calculator.add(1,2);
        // 异常通知 calculator. div(1,0);
    }
}
