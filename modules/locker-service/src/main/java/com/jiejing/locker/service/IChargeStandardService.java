package com.jiejing.locker.service;

import com.jiejing.locker.domains.ChargeStandard;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created by Bogle on 2016/9/2.
 */
public interface IChargeStandardService {

    Optional<ChargeStandard> findOneByBoxId(Integer id);

    Optional<ChargeStandard> findOneByDefaultBoxSize(Integer id);
}
