package com.example.springboot_demo2.design.one;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/7/31 14:49
 */
@OrderHandlerType(source = "pc", payMethod = "alipay")
public class PCAliPayOrderHandler implements OrderHandler {

    @Override
    public void handle(Order order) {
        System.out.println("pC 端处理订单 ，并且支付宝支付");

    }
}
