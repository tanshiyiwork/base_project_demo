package com.github;

import com.github.entity.UserBalance;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class JDBCTemplateSelect {

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
     * 2.查询表中有多少条记录
     */
    public void textCount() {
        // 创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        // 调用jdbcTemplate对象里面的方法来实现操作
        String sql = "select count(*) from user_balance";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    /**
     * 3.查询返回对象
     */
    public void textObject() {
        // 创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        // 调用jdbcTemplate对象里面的方法来实现操作
        String sql = "select * from user_balance where name=?";
        UserBalance userBalance = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "张三");
        System.out.println(userBalance);
    }

    /**
     * 查询返回链表
     */
    public void textList() {
        //利用c3p0来设置数据库信息
//		try {
//			ComboPooledDataSource dataSourse=new ComboPooledDataSource();
//			dataSourse.setDriverClass("oracle.jdbc.driver.OracleDriver");
//			dataSourse.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
//			dataSourse.setUser("scott");
//			dataSourse.setPassword("a");
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}
        // 创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        // 调用jdbcTemplate对象里面的方法来实现操作
        String sql = "select * from user_balance";
        List<UserBalance> list=jdbcTemplate.query(sql, new MyRowMapper());
        System.out.println(list);
    }

    class MyRowMapper implements RowMapper<UserBalance> {
        @Override
        public UserBalance mapRow(ResultSet rs, int num) throws SQLException {
            // 从结果集里面把数据得到
            int id = Integer.parseInt(rs.getString("id"));
            String name = rs.getString("name");
            Integer balance = Integer.parseInt(rs.getString("balance"));
            // 把得到的数据封装到对象里面
            UserBalance userBalance = new UserBalance();
            userBalance.setId(id);
            userBalance.setName(name);
            userBalance.setBalance(balance);
            return userBalance;
        }

    }
}
