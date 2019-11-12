package com.github;

import com.github.service.UserService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService2 {

    @Test
    public void testTx(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlTxConfig.xml");
        UserService2 service2=(UserService2) applicationContext.getBean("userService2");
        service2.accountMoney();
    }
}
