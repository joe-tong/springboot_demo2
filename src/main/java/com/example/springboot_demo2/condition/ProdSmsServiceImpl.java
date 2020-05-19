package com.example.springboot_demo2.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/19 16:07
 */
@Service
@ConditionalOnProperty(name = {"custom.env"}, havingValue = "prod")
public class ProdSmsServiceImpl implements SmsService {

    @Override
    public Boolean send(String mobile, String content) {
        System.out.println("短信发送成功, by ProdSmsServiceImpl");
        return true;
    }
}