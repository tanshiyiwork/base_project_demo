package com.github;

import com.github.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service=(UserService) applicationContext.getBean("userService");
        service.add();
    }

    @Test
    public void testTx(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service=(UserService) applicationContext.getBean("userService");
        service.accountMoney();
    }
}
