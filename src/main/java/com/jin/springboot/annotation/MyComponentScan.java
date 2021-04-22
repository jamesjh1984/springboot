package com.jin.springboot.annotation;


import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

/**
 * 自定义一个扫描器
 */
@Target({ElementType.TYPE}) // 申明级别
@Retention(RetentionPolicy.RUNTIME) // 生效范围
@Documented // 生成文档时候保留
@ComponentScan //加入扫描器注解，拥有了扫描器的基本功能
public @interface MyComponentScan {
    String[] value() default {}; // 用value方法定义扫描包范围
}
