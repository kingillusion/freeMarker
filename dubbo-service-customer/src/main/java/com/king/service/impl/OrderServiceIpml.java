package com.king.service.impl;

import com.king.bean.User;
import com.king.service.OrderService;
import com.king.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class OrderServiceIpml implements OrderService {

    @Autowired
    private UserService userService;
    @Override
    public void initOrder(String userId) {
        List<User> userAddress = userService.findUserAddress(userId);
        for (User u : userAddress) {
            System.out.println(u.getAddress());
        }
    }
}
