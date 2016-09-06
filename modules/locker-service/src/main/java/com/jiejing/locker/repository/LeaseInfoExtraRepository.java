package com.jiejing.locker.repository;

import com.jiejing.locker.domains.LeaseInfoExtra;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Bogle on 2016/9/6.
 */
@Mapper
public interface LeaseInfoExtraRepository {

    int save(LeaseInfoExtra leaseInfoExtra);

    int saveList(List<LeaseInfoExtra> leaseInfoExtras);
}
