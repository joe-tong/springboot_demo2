package com.example.springboot_demo2.impor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/20 11:22
 */
@Configuration
@Import({Apple.class, Banana.class})
public class AppConfig {
}
