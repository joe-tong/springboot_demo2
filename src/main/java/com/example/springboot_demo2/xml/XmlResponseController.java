package com.example.springboot_demo2.xml;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "xml")
public class XmlResponseController {

    @GetMapping(value = "xml/response" , produces = MediaType.APPLICATION_XML_VALUE)
    public UserXmlVO xmlResponse(){
        UserXmlVO userXmlVO = new UserXmlVO();
        userXmlVO.setName("童平平");

        OrderInfoVO vo = new OrderInfoVO();
        vo.setId("1");
        vo.setName("订单1号");

        OrderInfoVO vo2 = new OrderInfoVO();
        vo.setId("2");
        vo.setName("订单2号");

        userXmlVO.getOrderList().add(vo);
        userXmlVO.getOrderList().add(vo2);

        return userXmlVO;
    }
}
