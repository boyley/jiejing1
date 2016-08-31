package com.jiejing.locker.service;

import com.jiejing.locker.mapper.CabinetMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bogle on 2016/8/31.
 */
public class CabinetServiceTest extends AbsServiceTest {

    @Autowired
    public CabinetMapper cabinetMapper;

    @Test
    public void findOne() {
        this.cabinetMapper.findOne(1);
    }
}
