package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.ChargeStandard;
import com.jiejing.locker.repository.ChargeStandardRepository;
import com.jiejing.locker.service.IChargeStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Bogle on 2016/9/2.
 */
@Service
public class ChargeStandardServiceImpl implements IChargeStandardService {

    @Autowired
    private ChargeStandardRepository chargeStandardRepository;
    /**
     * 获取箱子的收费标准
     * @param id
     * @return
     */
    @Override
    public Optional<ChargeStandard> findOneByBoxId(Integer id) {
        return chargeStandardRepository.findOneByBoxId(id);
    }

    @Override
    public Optional<ChargeStandard> findOneByDefaultBoxSize(Integer id) {
        return chargeStandardRepository.findOneByDefaultBoxSize(id);
    }
}
