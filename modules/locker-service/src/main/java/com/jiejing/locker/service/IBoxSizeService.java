package com.jiejing.locker.service;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.BoxSize;

import java.util.List;

/**
 * Created by Bogle on 2016/8/31.
 */
public interface IBoxSizeService {

    boolean exists(Integer id);



    /**
     * 查询柜子拥有的所有箱子规格列表信息
     *
     * @param cabinetId
     * @return
     */
    List<BoxSize> findAll(Integer cabinetId);
}
