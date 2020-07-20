package com.example.springboot_demo2.lambda.cart;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/6/10 17:34
 */
public class Sku {
    private String name;
    private int count;

    public Sku(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
