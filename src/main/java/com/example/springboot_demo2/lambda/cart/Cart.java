package com.example.springboot_demo2.lambda.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/6/10 17:34
 */
public class Cart {
    public static void main(String[] args) {
        List<Sku> cartSkuList = new ArrayList<Sku>() {{
            add(new Sku("12", 1));
        }};
    }
}
