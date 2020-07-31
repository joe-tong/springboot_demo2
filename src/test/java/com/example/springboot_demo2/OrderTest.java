package com.example.springboot_demo2;

import com.example.springboot_demo2.design.one.Order;
import com.example.springboot_demo2.design.one.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/7/31 15:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemo2Application.class)
public class OrderTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void test(){
        Order order = new Order();
        order.setPayMethod("alipay");
        order.setSource("pc");
        orderService.orderService(order);
    }
}
