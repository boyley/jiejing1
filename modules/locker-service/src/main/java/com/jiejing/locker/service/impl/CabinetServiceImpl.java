package com.jiejing.locker.service.impl;

import com.jiejing.locker.mapper.CabinetMapper;
import com.jiejing.locker.service.ICabinetService;
import com.jiejing.locker.service.dto.CabinetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class CabinetServiceImpl implements ICabinetService {

    @Autowired
    public CabinetMapper cabinetMapper;

    @Override
    public CabinetDto save(CabinetDto cabinetDto) {
        return this.cabinetMapper.save(cabinetDto);
    }
}
