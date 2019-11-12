package com.github.service;

import com.github.dao.UserDao;

public class UserService2 {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        userDao.add();
    }

    //调用dao层
    //业务逻辑层，写转账的业务
    public void accountMoney(){
        //小王少1000
        userDao.lessMoney();

        //出现异常的话就会使得张三少了1000 但是李四没有多1000，导致数据丢失
        int i=10/0;

        //小李多1000
        userDao.moreMoney();
    }
}
