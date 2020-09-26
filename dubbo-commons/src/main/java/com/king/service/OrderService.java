package com.king.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public interface OrderService {

    void initOrder(String userId);
}
