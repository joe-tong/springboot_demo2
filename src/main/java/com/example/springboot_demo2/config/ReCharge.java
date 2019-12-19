package com.example.springboot_demo2.config;

import org.springframework.stereotype.Service;

@Service
public class ReCharge implements ReChargeAbstract {
    private int money;
    private String name;

    public String recharge(String name){
        this.money += money;
        return "收费记录:   "+ money+name;
    };
}
