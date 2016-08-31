package com.jiejing.locker.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bogle on 2016/8/31.
 */
public class BoxSizeServiceTest extends AbsServiceTest {

    @Autowired
    private IBoxSizeService boxSizeService;

    @Test
    public void findAll1() {
        this.printlnJson(this.boxSizeService.findAll(3));
    }
}
