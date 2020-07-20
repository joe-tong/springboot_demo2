package com.example.springboot_demo2.impor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/20 11:22
 */
public class ImportTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        for (String s : applicationContext.getBeanDefinitionNames()) {
            System.out.println(s);
        }
    }
}

