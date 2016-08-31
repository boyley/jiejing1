package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.repository.BoxRepository;
import com.jiejing.locker.service.IBoxSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

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

    @Override
    public Iterable<Box> save(Iterable<Box> entities) {
        Iterator<Box> iter = entities.iterator();
        while (iter.hasNext()) {
            Box box = iter.next();
            if (!this.exists(box.getId())) {
                throw new RuntimeException("规格id:" + box.getId() + "不存在，请联系管理员");
            }
        }
        return boxRepository.save(entities);
    }

    @Override
    public List<Box> findAll(Integer cabinetId) {
        return this.boxRepository.findAll(cabinetId);
    }
}
