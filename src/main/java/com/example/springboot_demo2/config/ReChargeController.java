package com.example.springboot_demo2.config;

import io.swagger.annotations.Api;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Bean注册")
@RestController
public class ReChargeController {

    @Autowired
    private ReChargeMapProcessor processor;

    @GetMapping("bean")
    private String rechargeByName(String name) {
        return processor.getReCharge("1").recharge(name);
    }
}
