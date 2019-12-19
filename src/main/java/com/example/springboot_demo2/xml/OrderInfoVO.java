package com.example.springboot_demo2.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class OrderInfoVO {
    @JacksonXmlProperty(localName = "order_name")
    private String name;
    @JacksonXmlProperty(localName = "order_id")
    private String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
