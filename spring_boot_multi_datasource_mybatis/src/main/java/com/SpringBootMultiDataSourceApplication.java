package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * <p>
 * SpringBoot启动类
 * </p>
 *
 * @package: com.github
 * @description: SpringBoot启动类
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SpringBootMultiDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMultiDataSourceApplication.class, args);
    }

}
