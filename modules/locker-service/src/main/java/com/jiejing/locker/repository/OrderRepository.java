package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/31.
 */
@Mapper
public interface OrderRepository {

    Order findOneById(Integer id);

    int save(Order order);

    void update(Order order);
}
