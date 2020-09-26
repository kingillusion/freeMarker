package com.king.service.impl;

import com.king.bean.User;
import com.king.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService{

    @Override
    public List<User> findUserAddress(String userId) {
        List<User> userList = new ArrayList<>();
        User u = new User(1,"1","地址1");
        User u2 = new User(2,"1","地址2");
        return Arrays.asList(u,u2);
    }
}
