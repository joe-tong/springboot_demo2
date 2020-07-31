package com.example.springboot_demo2.design.one;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/7/31 14:10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface OrderHandlerType {
    String source();
    String payMethod();
}

