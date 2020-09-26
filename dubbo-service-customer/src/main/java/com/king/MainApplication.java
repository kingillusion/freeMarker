package com.king;

import com.king.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("customer.xml");
        context.start();
        OrderService orderService = context.getBean(OrderService.class);
        orderService.initOrder("1");
        System.in.read(); // 按任意键退出
    }
}
