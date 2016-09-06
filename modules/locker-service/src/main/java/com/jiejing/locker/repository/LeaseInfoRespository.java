package com.jiejing.locker.repository;

import com.jiejing.locker.domains.LeaseInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Bogle on 2016/9/2.
 */
@Mapper
public interface LeaseInfoRespository  {

    int save(LeaseInfo leaseInfo);
}
