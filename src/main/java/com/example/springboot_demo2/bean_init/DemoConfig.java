package com.example.springboot_demo2.bean_init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

	@Bean(initMethod = "initMethod")
	public DemoBean demoBean() {
		return new DemoBean();
	}
}