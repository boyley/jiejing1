package com.jiejing.locker.service.impl;

import com.jiejing.locker.defines.Const;
import com.jiejing.locker.domains.Box;
import com.jiejing.locker.repository.BoxRepository;
import com.jiejing.locker.service.IBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class BoxServiceImpl implements IBoxService {

    @Autowired
    private BoxRepository boxRepository;

    @Override
    public Optional<Box> findOne(Integer id) {
        return boxRepository.findOneById(id);
    }

    @Override
    public Iterable<Box> save(Iterable<Box> entities) {
        Iterator<Box> iter = entities.iterator();

//        return boxRepository.save(entities);
        return null;
    }

    @Override
    public Box findOneEnableBox(Integer boxSizeId) {
        return boxRepository.findOneEnableBox(boxSizeId);
    }

    @Override
    public int update(Box box) {
        return boxRepository.update(box);
    }
}
