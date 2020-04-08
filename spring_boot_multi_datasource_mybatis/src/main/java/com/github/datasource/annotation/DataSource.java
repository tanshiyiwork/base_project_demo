package com.github.datasource.annotation;

import java.lang.annotation.*;

/**
 * alair 多数据源注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
