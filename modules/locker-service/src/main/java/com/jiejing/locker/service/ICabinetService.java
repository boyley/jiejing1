package com.jiejing.locker.service;

import com.jiejing.locker.domains.BoxSize;
import com.jiejing.locker.domains.Cabinet;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Bogle on 2016/8/30.
 */
public interface ICabinetService {

    /**
     * 保存柜子信息
     *
     * @param cabinet
     */
    Cabinet save(Cabinet cabinet);

    Optional<Cabinet> findOne(Integer id);

    Optional<List<BoxSize>> findBoxSize(int id);
}
