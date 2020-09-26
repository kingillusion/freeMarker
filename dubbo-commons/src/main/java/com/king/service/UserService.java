package com.king.service;

import com.king.bean.User;

import java.util.List;

public interface UserService {

    List<User> findUserAddress(String userId);
}
