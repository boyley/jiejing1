package com.jiejing.locker.service;

import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.repository.CabinetRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bogle on 2016/8/31.
 */
public class CabinetServiceTest extends AbsServiceTest {


    @Autowired
    private CabinetRepository cabinetRepository;


    @Autowired
    private ILeaseBoxService leaseBoxService;

    @Test
    public void leaseBox() {
        LeaseBox leaseBox = new LeaseBox();
        leaseBox.setCabinetId(1);
        leaseBox.setCheckCode("SFZ");
        printlnJson(leaseBoxService.quXiang(leaseBox).toArray());
    }

    @Test
    public void findBoxSize() {
        printlnJson(cabinetRepository.findBoxSize(1));
    }
}
