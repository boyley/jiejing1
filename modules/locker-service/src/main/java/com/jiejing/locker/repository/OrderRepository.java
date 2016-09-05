package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/31.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findOneById(Integer id);
}
