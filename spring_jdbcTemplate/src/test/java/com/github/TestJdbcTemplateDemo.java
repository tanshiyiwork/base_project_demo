package com.github;

import org.junit.Test;

public class TestJdbcTemplateDemo {

    @Test
    public void test1(){
        JDBCTemplateDemo jdbcTemplateDemo = new JDBCTemplateDemo();
        //jdbcTemplateDemo.add();
        //jdbcTemplateDemo.update();
        jdbcTemplateDemo.delete();
    }
}
