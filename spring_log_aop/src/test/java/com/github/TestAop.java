package com.github;

import com.github.testaop.Book;
import com.github.testaop.Computer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class TestAop {

    @Test
    public void testXmlAop(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book=(Book) context.getBean("book");
        book.addBook();
        log.debug("fdfdsa===================");
    }


    /**
     * 测试AOP注解，由于需要配置spring-mvc，所以将自动开启aop注解的配置添加在spring-mvc.xml中
     * 要测试此例，需在applicationContext.xml中开启aop注解
     */
    @Test
    public void testAnnoAop(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Computer computer = (Computer)context.getBean("computer");
        computer.say();
    }
}
