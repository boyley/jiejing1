package com.jiejing.locker.service;

import com.jiejing.locker.domains.Order;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/31.
 */
public interface IOrderService {

    Optional<Order> save(Order order);

    Optional<Order> findOne(Integer id);
}
