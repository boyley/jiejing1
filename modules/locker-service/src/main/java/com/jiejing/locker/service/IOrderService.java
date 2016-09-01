package com.jiejing.locker.service;

import com.jiejing.locker.domains.Order;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/31.
 */
public interface IOrderService {

    Order save(Order order);
}
