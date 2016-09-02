package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.BoxChargeStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Bogle on 2016/9/2.
 */
public interface BoxChargeStandardRepository extends JpaRepository<BoxChargeStandard, Integer>, QueryDslPredicateExecutor<BoxChargeStandard> {
}
