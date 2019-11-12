package com.github;

import com.github.testaop.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book=(Book) context.getBean("book");
        book.addBook();
    }

    @Test
    public void testXmlAop(){
        ApplicationContext context=new ClassPathXmlApplicationContext("xmlAop.xml");
        Book book=(Book) context.getBean("book");
        book.addBook();
    }
}
