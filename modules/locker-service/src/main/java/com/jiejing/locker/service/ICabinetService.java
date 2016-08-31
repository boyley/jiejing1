package com.jiejing.locker.service;

import com.jiejing.locker.service.dto.CabinetDto;

/**
 * Created by Bogle on 2016/8/30.
 */
public interface ICabinetService {

    /**
     * 保存柜子信息
     *
     * @param cabinetDto
     */
    CabinetDto save(CabinetDto cabinetDto);
}
