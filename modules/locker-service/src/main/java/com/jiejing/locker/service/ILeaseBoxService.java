package com.jiejing.locker.service;

import com.jiejing.locker.domains.LeaseBox;

import java.util.stream.Stream;

/**
 * Created by Bogle on 2016/8/31.
 */
public interface ILeaseBoxService {

    LeaseBox save(LeaseBox leaseBox);

    /**
     * 使用验证的资料信息获取箱子
     *
     * @param leaseBox
     * @return
     */
    Stream<LeaseBox> quXiang(LeaseBox leaseBox);
}
