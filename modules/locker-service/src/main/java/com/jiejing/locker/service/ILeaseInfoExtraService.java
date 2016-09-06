package com.jiejing.locker.service;

import com.jiejing.locker.domains.LeaseInfoExtra;

import java.util.List;

/**
 * Created by Bogle on 2016/9/6.
 */
public interface ILeaseInfoExtraService {

    int save(LeaseInfoExtra leaseInfoExtra);

    int saveList(List<LeaseInfoExtra> leaseInfoExtras);
}
