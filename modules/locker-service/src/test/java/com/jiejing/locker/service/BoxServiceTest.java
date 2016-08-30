package com.jiejing.locker.service;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.repository.BoxRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;

/**
 * Created by Bogle on 2016/8/30.
 */
public class BoxServiceTest extends AbsServiceTest {

    @Autowired
    private BoxRepository boxRepository;

    @Test
    public void saveTest() {
        Box box = new Box();
        box.setCreatedBy(1);
        box.setCreatedDate(ZonedDateTime.now());
        box.setLastModifiedBy(1);
        box.setLastModifiedDate(ZonedDateTime.now());

        box.setCode("code");
        box.setDescription("description");
        box.setCabinetId(3);
        box.setBoxSizeId(1);

        box.setGateLockState(Box.GateLockState.CLOSE);
        box.setDepositState(Box.DepositState.Y);
        box.setStatus(Cabinet.Status.ENABLE);
        this.boxRepository.save(box);
    }
}
