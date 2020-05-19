package com.example.springboot_demo2.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * 测试环境短信通道
 *
 * @author WeJan
 * @since 2020-04-28
 */
@Service
@ConditionalOnProperty(name = {"custom.env"}, havingValue = "test")
public class TestSmsServiceImpl implements SmsService {
    @Override
    public Boolean send(String mobile, String content) {
        System.out.println("短信发送成功, by TestSmsServiceImpl");
        return true;
    }
}