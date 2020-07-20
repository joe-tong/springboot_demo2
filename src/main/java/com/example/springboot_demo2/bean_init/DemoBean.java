package com.example.springboot_demo2.bean_init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/6/9 9:34
 */
@Slf4j
public class DemoBean implements InitializingBean {

    public DemoBean() {
        log.info("--> instantiate ");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("--> @PostConstruct ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("--> InitializingBean.afterPropertiesSet ");
    }

    public void initMethod() {
        log.info("--> custom initMehotd");
    }
}