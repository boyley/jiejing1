package com.jiejing.locker.service;

import com.jiejing.locker.domains.Box;

/**
 * Created by Bogle on 2016/8/31.
 */
public interface IBoxService {

    Box findOne(Integer id);

    Iterable<Box> save(Iterable<Box> entities);
}
