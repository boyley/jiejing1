package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Region;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Bogle on 2016/8/29.
 */
@Mapper
public interface RegionRepository  {
    boolean exists(Integer id);
}
