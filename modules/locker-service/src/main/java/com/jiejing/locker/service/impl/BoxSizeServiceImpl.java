package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.BoxSize;
import com.jiejing.locker.repository.BoxRepository;
import com.jiejing.locker.repository.BoxSizeRepository;
import com.jiejing.locker.service.IBoxSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class BoxSizeServiceImpl implements IBoxSizeService {

    @Autowired
    private BoxSizeRepository boxSizeRepository;

    @Override
    public Optional<BoxSize> findOne(Integer id) {
        return boxSizeRepository.findOneById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return boxSizeRepository.exists(id);
    }


    @Override
    public Optional<List<BoxSize>> findAll(Integer cabinetId) {
        return this.boxSizeRepository.findAll(cabinetId);
    }
}
