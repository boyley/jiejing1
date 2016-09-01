package com.jiejing.locker.service;

import com.jiejing.locker.domains.Box;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/31.
 */
public interface IBoxService {

    Optional<Box> findOne(Integer id);

    Iterable<Box> save(Iterable<Box> entities);
}
