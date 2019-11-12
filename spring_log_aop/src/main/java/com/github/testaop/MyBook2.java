package com.github.testaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyBook2 {

    public void before1(){
        System.out.println("前置增强");
    }

    public void after1(){
        System.out.println("后置增强");
    }

    //环绕通知
    public void around1(ProceedingJoinPoint pro) throws Throwable{
        //方法之前
        System.out.println("方法之前");

        //执行被增强的方法
        pro.proceed();

        //方法之后
        System.out.println("方法之后");
    }
}
