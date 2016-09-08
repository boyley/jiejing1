package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Keeplive;
import com.jiejing.locker.repository.KeepliveRepository;
import com.jiejing.locker.service.IKeepliveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Bogle on 2016/9/7.
 */
@Service
public class KeepliveServiceImpl implements IKeepliveService {
    @Autowired
    private KeepliveRepository keepliveRepository;



    @Override
    @Transactional
    public int save(Keeplive keeplive) {
        return keepliveRepository.save(keeplive);
    }

    @Override
    public int save(List<Keeplive> keeplives) {
        return keepliveRepository.saveList(keeplives);
    }
}
