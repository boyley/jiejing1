package com.jiejing.locker.service;

import com.jiejing.locker.domains.Cabinet;

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

    Cabinet findOne(Integer id);
}
