package com.example.springboot_demo2.config;

import com.google.common.collect.Maps;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class ReChargeMapProcessor {
    public static final Map<String, ReChargeAbstract> map = Maps.newConcurrentMap();

    @Autowired
    private ReCharge reCharge;

    @PostConstruct
    public void initReChargeStrategy() {
        map.put("1", reCharge);
    }

    ;

    public ReChargeAbstract getReCharge(String key) {
        return map.get(key);
    }

}
