package com.example.springboot_demo2.condition;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/19 16:06
 */
public interface SmsService {
    Boolean send(String mobile, String content);
}