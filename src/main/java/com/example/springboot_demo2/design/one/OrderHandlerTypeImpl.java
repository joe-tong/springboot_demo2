package com.example.springboot_demo2.design.one;

import java.lang.annotation.Annotation;

/**
 * @Author: Joe
 * @Description:
 * @Date 2020/7/31 14:39
 */
public class OrderHandlerTypeImpl implements OrderHandlerType {
    private String source;
    private String payMethod;

    public OrderHandlerTypeImpl(String source, String payMethod) {
        this.source = source;
        this.payMethod = payMethod;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return OrderHandlerType.class;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;

        hashCode += (127 * "source".hashCode()) ^ source.hashCode();
        hashCode += (127 * "payMethod".hashCode()) ^ payMethod.hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OrderHandlerType)) {
            return false;
        }
        OrderHandlerType other = (OrderHandlerType) object;

        return source.equals(other.source()) && payMethod.equals(other.payMethod());
    }


    @Override
    public String source() {
        return this.source;
    }

    @Override
    public String payMethod() {
        return this.payMethod;
    }
}
