package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.repository.BoxRepository;
import com.jiejing.locker.service.IBoxService;
import com.jiejing.locker.service.IBoxSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class BoxServiceImpl implements IBoxService {

    @Autowired
    private IBoxSizeService boxSizeService;

    @Autowired
    private BoxRepository boxRepository;

    @Override
    public Iterable<Box> save(Iterable<Box> entities) {
        Iterator<Box> iter = entities.iterator();
        while (iter.hasNext()) {
            Box box = iter.next();
            if (!this.boxSizeService.exists(box.getId())) {
                throw new RuntimeException("规格id:" + box.getId() + "不存在，请联系管理员");
            }
        }
        return boxRepository.save(entities);
    }
}
