package com.jiejing.locker.service;

import com.jiejing.locker.repository.CabinetRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bogle on 2016/8/31.
 */
public class CabinetServiceTest extends AbsServiceTest {


    @Autowired
    private CabinetRepository cabinetRepository;

    @Test
    public void findBoxSize() {
        printlnJson(cabinetRepository.findBoxSize(1));
    }
}
