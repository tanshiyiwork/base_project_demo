package com.github.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    //得到JdbcTemplate对象
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add() {
        // 1.设置数据库信息
//		DriverManagerDataSource datasource = new DriverManagerDataSource();
//		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");// 驱动的名字
//		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");// 数据库的地址
//		datasource.setUsername("scott");
//		datasource.setPassword("a");

        // 创建jdbcTemplate对象，设置数据源
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        String sql="insert into user_balance values(?,?,?)";
        //jdbcTemplate.execute("insert into user_balance values(?,?)");
        jdbcTemplate.update(sql, 3,"李磊",2000);

    }

    /**
     * 做对数据库操作的方法，不写业务操作
     */
    //张三少钱方法
    public void lessMoney(){
        String sql="update user_balance set balance=balance-? where name=?";
        jdbcTemplate.update(sql, 1000,"张三");
    }

    //李四多钱的方法
    public void moreMoney(){
        String sql="update user_balance set balance=balance+? where name=?";
        jdbcTemplate.update(sql, 1000,"李四");
    }
}
