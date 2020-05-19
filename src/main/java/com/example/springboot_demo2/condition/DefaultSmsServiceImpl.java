package com.example.springboot_demo2.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnMissingBean(value = {DevSmsServiceImpl.class, TestSmsServiceImpl.class, ProdSmsServiceImpl.class})
public class DefaultSmsServiceImpl implements SmsService {

    @Override
    public Boolean send(String mobile, String content) {
        System.out.println("短信发送成功, by DefaultSmsServiceImpl");
        return true;
    }
}
