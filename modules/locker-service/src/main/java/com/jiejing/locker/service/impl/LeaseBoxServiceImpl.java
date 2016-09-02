package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.repository.LeaseBoxRepository;
import com.jiejing.locker.service.ILeaseBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class LeaseBoxServiceImpl implements ILeaseBoxService {

    @Autowired
    private LeaseBoxRepository leaseBoxRepository;

    @Override
    public LeaseBox save(LeaseBox leaseBox) {
        return leaseBoxRepository.save(leaseBox);
    }
}
