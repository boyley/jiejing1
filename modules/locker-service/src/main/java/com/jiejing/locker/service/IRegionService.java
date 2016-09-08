package com.jiejing.locker.service;

import com.jiejing.locker.domains.Region;

/**
 * Created by Bogle on 2016/8/31.
 */
public interface IRegionService {

    boolean exists(Integer id);

    Region findOne(Integer regionId);
}
