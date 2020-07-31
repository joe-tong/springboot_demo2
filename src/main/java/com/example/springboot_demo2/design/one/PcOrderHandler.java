package com.example.springboot_demo2.design.one;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/7/31 14:12
 */
//@OrderHandlerType(source = "pc")
public class PcOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("处理pc端订单");
    }
}
