package com.jiejing.locker.service.impl;

import com.jiejing.locker.repository.BoxRepository;
import com.jiejing.locker.service.IBoxSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class BoxSizeServiceImpl implements IBoxSizeService {

    @Autowired
    private BoxRepository boxRepository;

    @Override
    public boolean exists(Integer id) {
        return boxRepository.exists(id);
    }
}
