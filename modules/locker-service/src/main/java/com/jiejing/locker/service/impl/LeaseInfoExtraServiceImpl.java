package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.LeaseInfoExtra;
import com.jiejing.locker.repository.LeaseInfoExtraRepository;
import com.jiejing.locker.repository.LeaseInfoRespository;
import com.jiejing.locker.service.ILeaseInfoExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Bogle on 2016/9/6.
 */
@Service
public class LeaseInfoExtraServiceImpl implements ILeaseInfoExtraService {

    @Autowired
    private LeaseInfoExtraRepository leaseInfoExtraRepository;

    public int save(LeaseInfoExtra leaseInfoExtra) {
        return leaseInfoExtraRepository.save(leaseInfoExtra);
    }

    public int saveList(List<LeaseInfoExtra> leaseInfoExtras) {
        return leaseInfoExtraRepository.saveList(leaseInfoExtras);
    }
}
