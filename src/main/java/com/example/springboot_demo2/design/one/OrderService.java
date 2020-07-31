package com.example.springboot_demo2.design.one;

import com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/7/31 14:09
 */
@Service
public class OrderService {

    private Map<OrderHandlerType,OrderHandler> orderHandlerMap;

    @Autowired
    public void setOrderHandlerMap(List<OrderHandler> orderHandlers) {
        //注入各种类型的订单处理类
        orderHandlerMap = orderHandlers.stream().collect(
                Collectors.toMap(orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(),
                        OrderHandlerType.class), v -> v, (v1, v2) -> v1));
    }

    public void orderService(Order order) {
        //... 一些前置处理

        //通过订单来源和支付方式获取对应的handler
        OrderHandlerType orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
        OrderHandler orderHandler = orderHandlerMap.get(orderHandlerType);
        orderHandler.handle(order);

        //... 一些后置处理
    }
}
