package com.example.springboot_demo2;

import com.example.springboot_demo2.condition.SmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/5/19 16:09
 */
@RunWith(SpringRunner.class)
//@ActiveProfiles(value = "prod")
//@ActiveProfiles(value = "dev")
@ActiveProfiles(value = "test")
@SpringBootTest(classes = SpringbootDemo2Application.class)
public class SmsServiceTest {
    @Resource
    private SmsService smsService;

    @Value("${custom.env}")
    private String env;

    @Test
    public void testSend() {
        System.out.println(env);
        smsService.send("13333333333", "Test");
    }
}