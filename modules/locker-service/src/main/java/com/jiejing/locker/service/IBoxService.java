package com.jiejing.locker.service;

import com.jiejing.locker.defines.Const;
import com.jiejing.locker.domains.Box;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/31.
 */
public interface IBoxService {

    Optional<Box> findOne(Integer id);

    int saveList(Iterable<Box> entities);

    Box findOneEnableBox(Integer boxSizeId);

    int update(Box box);
}
