package com.github;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;
import java.util.Properties;

public class JDBCTemplateDemo {

    private static Properties properties;
    private static DriverManagerDataSource datasource;

    static {
        properties = new Properties();
        datasource = new DriverManagerDataSource();
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("dbconfig.properties");
            // 1.设置数据库信息
            datasource.setDriverClassName(properties.getProperty("driverClassName"));// 驱动的名字
            datasource.setUrl(properties.getProperty("url"));// 数据库的地址
            datasource.setUsername(properties.getProperty("username"));
            datasource.setPassword(properties.getProperty("password"));
            //System.out.println(new String(properties.getProperty("warshipType.2").getBytes("iso-8859-1"), "gbk"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 添加操作
     */
    public void add() {
        // 创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        // 调用jdbcTemplate对象里面的方法来实现操作
        // 创建sql语句
        String sql = "insert into user_balance values(?,?,?)";
        int rows = jdbcTemplate.update(sql, 4,"肖武", 2345);
        System.out.println(rows);
    }

    /**
     * 修改操作
     */
    public void update() {
        // 创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        // 调用jdbcTemplate对象里面的方法来实现操作
        String sql="update user_balance set balance=? where name=?";
        int rows=jdbcTemplate.update(sql, 789,"肖武");
        System.out.println(rows);
    }

    /**
     * 删除操作
     */
    public void delete() {
        // 创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        // 调用jdbcTemplate对象里面的方法来实现操作
        String sql="delete from user_balance where name=?";
        int rows=jdbcTemplate.update(sql,"肖武");
        System.out.println(rows);
    }
}
