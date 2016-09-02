package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.LeaseInfo;
import com.jiejing.locker.repository.LeaseInfoRespository;
import com.jiejing.locker.service.ILeaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bogle on 2016/9/2.
 */
@Service
public class LeaseInfoServiceImpl implements ILeaseInfoService {

    @Autowired
    private LeaseInfoRespository leaseInfoRespository;

    @Override
    public LeaseInfo save(LeaseInfo leaseInfo) {
        return leaseInfoRespository.save(leaseInfo);
    }
}
