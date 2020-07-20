package com.example.springboot_demo2.bean_init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/6/9 9:34
 */
@Configuration
@Slf4j
public class DemoBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("demoBean".equals(beanName)){
            log.info("--> BeanPostProcessor.postProcessBeforeInitialization ");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("demoBean".equals(beanName)){
            log.info("--> BeanPostProcessor.postProcessAfterInitialization ");
        }
        return bean;
    }
}
