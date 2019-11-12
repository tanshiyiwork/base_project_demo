package com.github.testaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyBook {

    //在方法上面使用注解完成增强配置
    @Before(value="execution(* com.github.testaop.Book.*(..))")
    public void before1(){
        System.out.println("before1...");
    }
}
