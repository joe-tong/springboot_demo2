package com.example.springboot_demo2.design.one;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/7/31 14:51
 */
@OrderHandlerType(source = "mb",payMethod = "wechart")
public class MobileWechartOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {

    }
}
